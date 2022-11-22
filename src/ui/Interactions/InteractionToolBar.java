package ui.Interactions;

import ui.ToolBar;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class InteractionToolBar extends MouseInputAdapter {

    private final ToolBar toolBar;

    public InteractionToolBar(ToolBar toolBar){
        this.toolBar = toolBar;
        toolBar.addMouseListener(this);
        toolBar.addMouseMotionListener(this);
        toolBar.addMouseWheelListener(this);
    }

    public void mousePressed(MouseEvent e){
        toolBar.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e){
        toolBar.mouseReleased(e);
    }

    public void mouseDragged(MouseEvent e){
        toolBar.mouseDragged(e);
    }
}
