package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Button {

    private ImageIcon image;
    private ActionListener actionListener;
    private EtatButton etatButton;

    public Button(ImageIcon imageIcon) {
        image = imageIcon;
        etatButton = EtatButton.Base;
    }

    public ImageIcon getImage(){
        return image;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public EtatButton getEtatButton() {
        return etatButton;
    }

    public void setEtatButton(EtatButton etatButton) {
        this.etatButton = etatButton;
    }

    public void clicked(){
        actionListener.actionPerformed(new ActionEvent(this, 0, ""));
    }
}
