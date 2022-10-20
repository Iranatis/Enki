package ui;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;

public abstract class Panel extends MouseInputAdapter {

    protected int width, height;

    public Panel(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract boolean mouseMove(int x, int y);

    public abstract boolean mouseLeftClick(int x, int y);

    public abstract boolean mouseRightClick(int x, int y);

    public abstract void paint(Graphics g);
}
