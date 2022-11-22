package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ToolBar extends JPanel {

    private final ArrayList<Button> buttons;
    private final Color couleur = new Color(40, 40, 40);

    ToolBar(){
        buttons = new ArrayList<>();
    }

    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){

    }

    public void paint(Graphics g){
        Color back = g.getColor();

        g.setColor(couleur);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(back);
    }
}
