package ui;

import fc.GestionnaireImage;
import ui.Intaractions.InteractionImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {

    GestionnaireImage gestionnaireImage;

    double sep = 0.05;

    Main(){
        super("Enki");

        addKeyListener(this);
        setFocusable(true);

        gestionnaireImage = GestionnaireImage.getInstance();

        ToolBar toolBar = new ToolBar();
        Image image = new Image();

        new InteractionImage(image);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = sep;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        add(toolBar, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1-sep;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 9;
        add(image, gbc);

        ActionListener actionListener = e -> repaint();

        Timer t = new Timer(20, actionListener);
        t.start();

        //Les détails de création de ma fenêtre
        setLocation(1000, 250);
        setSize(400, 250);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                // handle up
                break;
            case KeyEvent.VK_DOWN:
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                gestionnaireImage.before();
                break;
            case KeyEvent.VK_RIGHT :
                gestionnaireImage.next();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        GestionnaireImage gestionnaireImage = GestionnaireImage.getInstance();

        for (String arg : args){
            gestionnaireImage.add(arg);
        }

        SwingUtilities.invokeLater(Main::new);
    }
}
