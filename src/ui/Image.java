package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Image extends Panel{

    private BufferedImage picture;
    private final Color couleur = new Color(50, 50, 50);

    public Image(int width, int height) {
        super(width, height);
    }

    public void setPicture(BufferedImage picture) {
        this.picture = picture;
    }

    @Override
    public boolean mouseMove(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        return true;
    }

    @Override
    public boolean mouseLeftClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        return true;
    }

    @Override
    public boolean mouseRightClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        return true;
    }

    @Override
    public void paint(Graphics g) {
        Color back = g.getColor();

        g.setColor(couleur);
        g.fillRect(0, 0, width, height);

        g.setColor(back);
    }
}
