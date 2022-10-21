package ui;

import fc.GestionnaireImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class Image extends JPanel {

    GestionnaireImage gestionnaireImage = GestionnaireImage.getInstance();

    private BufferedImage picture;
    private final Color couleur = new Color(50, 50, 50);

    public Image() {
    }

    public void setPicture(BufferedImage picture) {
        this.picture = picture;
    }

   /* public void mouseLeftClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        if (x < width/10) gestionnaireImage.before();
        if (x > 9*width/10) gestionnaireImage.next();
        return true;
    }

    @Override
    public boolean mouseRightClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        return true;
    }*/

    public void paint(Graphics g) {
        Color back = g.getColor();

        setPicture(gestionnaireImage.getImage());

        Rectangle recG = g.getClipBounds();

        g.setColor(couleur);
        g.fillRect(0, 0, (int) recG.getWidth(), (int) recG.getHeight());

        if (picture != null){
            double zoom = Math.min(recG.getWidth()/picture.getWidth(), recG.getHeight()/ picture.getWidth());
            zoom *= gestionnaireImage.getFixed_prop();
            gestionnaireImage.setZoom(zoom);
            int wP = (int) (picture.getWidth() * zoom);
            int wH = (int) (picture.getHeight() * zoom);

            g.drawImage(picture, (int) ((recG.getWidth() - wP)/2) + gestionnaireImage.getDecX(), (int) ((recG.getHeight() - wH)/2) + gestionnaireImage.getDecY(), wP, wH, null);
        }

        g.setColor(back);
    }
}
