package ui.Intaractions;

import fc.GestionnaireImage;
import ui.Image;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class InteractionImage extends MouseInputAdapter {

    GestionnaireImage gestionnaireImage;

    Image image;

    enum State {IDLE, ARMED_L, PANNING_L, PRESS_L_N, PRESS_L_B}

    private State state = State.IDLE;
    private int posBaseX, posdBaseY;

    public InteractionImage(Image image){
        this.image = image;
        image.addMouseListener(this);
        image.addMouseMotionListener(this);
        image.addMouseWheelListener(this);
        gestionnaireImage = GestionnaireImage.getInstance();
    }

    public void mousePressed(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (image.inImage(e.getX(), e.getY()) && state == State.IDLE) {
                posBaseX = e.getX();
                posdBaseY = e.getY();
                state = State.ARMED_L;
            }
            if (state == State.IDLE && e.getX() > 9 * image.getWidth() / 10) state = State.PRESS_L_N;
            if (state == State.IDLE && e.getX() < image.getWidth() / 10) state = State.PRESS_L_B;
        }
    }

    public void mouseReleased(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1){
            if (state == State.ARMED_L) state = State.IDLE;
            if (state == State.PANNING_L) state = State.IDLE;
            if (state == State.PRESS_L_N && e.getX() > 9* image.getWidth()/10) {
                gestionnaireImage.next();
                state = State.IDLE;
            }
            if (state == State.PRESS_L_B && e.getX() < image.getWidth()/10) {
                gestionnaireImage.before();
                state = State.IDLE;
            }
        }
    }

    public void mouseDragged(MouseEvent e){
        if (state == State.IDLE) return;
        int distX = e.getX() - posBaseX;
        int distY = e.getY() - posdBaseY;
        int dist = (int) Math.sqrt((double) distX*distX + distY*distY);
        if (dist > 5 && state == State.ARMED_L) state = State.PANNING_L;
        if (state == State.PANNING_L) {
            gestionnaireImage.addDecX(distX);
            gestionnaireImage.addDecY(distY);
            posBaseX = e.getX();
            posdBaseY = e.getY();
        }
    }
}
