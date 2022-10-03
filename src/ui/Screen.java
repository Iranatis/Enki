package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JPanel implements KeyListener {

    private static Screen instance;

    private final int width = 1600;
    private final int height = 900;
    private final double sep = 0.05;

    private final ToolBar toolBar;
    private final Image image;

    private Screen(){
        addKeyListener(this);
        setFocusable(true);

        toolBar = new ToolBar(width, (int) (height*sep));
        image = new Image(width, (int) (height*(1-sep)));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)){
                    toolBar.mouseLeftClick(e.getX(), e.getY());
                    image.mouseLeftClick(e.getX(), e.getY() + (int) (height*sep));
                } else if (SwingUtilities.isRightMouseButton(e)){
                    toolBar.mouseRightClick(e.getX(), e.getY());
                    image.mouseRightClick(e.getX(), e.getY() + (int) (height*sep));
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                toolBar.mouseMove(e.getX(), e.getY());
                image.mouseMove(e.getX(), e.getY() + (int) (height*sep));
            }
        });
    }

    public static Screen getInstance(){
        if (instance == null) instance = new Screen();
        return instance;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.pink);
        g.fillRect(0, 0, getWidth(), getHeight());

        toolBar.paint(g.create(0, 0, width, (int) (height*sep)));
        image.paint(g.create(0, (int) (height*sep), width, (int) (height*(1-sep))));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
