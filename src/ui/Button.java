package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Button {

    private int x,y,w,h;
    private BufferedImage imageBase, imageMouse, imageClick;
    private ActionListener actionListener;
    private EtatButton etatButton;

    public Button(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public BufferedImage getImageBase() {
        return imageBase;
    }

    public void setImageBase(BufferedImage imageBase) {
        this.imageBase = imageBase;
    }

    public BufferedImage getImageMouse() {
        return imageMouse;
    }

    public void setImageMouse(BufferedImage imageMouse) {
        this.imageMouse = imageMouse;
    }

    public BufferedImage getImageClick() {
        return imageClick;
    }

    public void setImageClick(BufferedImage imageClick) {
        this.imageClick = imageClick;
    }

    public BufferedImage getImage(){
        switch (etatButton){
            case Base:
                return getImageBase();
            case Mouse:
                return getImageMouse();
            case Click:
                return getImageClick();
        }
        return null;
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

    public boolean contains(int x, int y){
        return x >= this.x && x <= (this.x + w) && y >= this.y && y <= (this.y + h);
    }

    public void clicked(){
        actionListener.actionPerformed(new ActionEvent(this, 0, ""));
    }
}
