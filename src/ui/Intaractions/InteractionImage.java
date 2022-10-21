package ui.Intaractions;

import fc.GestionnaireImage;
import ui.Image;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class InteractionImage extends MouseInputAdapter {

    GestionnaireImage gestionnaireImage;

    Image image;

    enum State {IDLE, ARMED_L, PANNING_L};

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
            posBaseX = e.getX();
            posdBaseY = e.getY();
            if (state == State.IDLE) state = State.ARMED_L;
        }
    }

    public void mouseReleased(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1){
            if (state == State.ARMED_L) state = State.IDLE;
            if (state == State.PANNING_L) state = State.IDLE;
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
