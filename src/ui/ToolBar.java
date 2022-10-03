package ui;

import java.awt.*;
import java.util.ArrayList;

public class ToolBar extends Panel {

    private final ArrayList<Button> buttons;
    private final Color couleur = new Color(40, 40, 40);

    ToolBar(int width, int height){
        super(width, height);
        buttons = new ArrayList<>();
    }

    @Override
    public boolean mouseMove(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        for (Button button : buttons){
            if (button.contains(x, y)){
                button.setEtatButton(EtatButton.Mouse);
            } else {
                button.setEtatButton(EtatButton.Base);
            }
        }
        return true;
    }

    @Override
    public boolean mouseLeftClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        for (Button button : buttons){
            if (button.contains(x, y)){
                button.setEtatButton(EtatButton.Click);
                button.clicked();
                button.setEtatButton(EtatButton.Base);
            }
        }
        return true;
    }

    @Override
    public boolean mouseRightClick(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) return false;
        return true;
    }

    public void paint(Graphics g){
        Color back = g.getColor();

        g.setColor(couleur);
        g.fillRect(0, 0, width, height);

        g.setColor(back);
    }
}
