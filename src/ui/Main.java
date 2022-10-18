package ui;

import fc.GestionnaireImage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Main(){
        super("Enki");

        add(Screen.getInstance());

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };

        Timer t = new Timer(100, actionListener);
        t.start();

        //Les détails de création de ma fenêtre
        setLocation(1000, 250);
        setSize(400, 250);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GestionnaireImage gestionnaireImage = GestionnaireImage.getInstance();

        for (String arg : args){
            gestionnaireImage.add(arg);
        }

        SwingUtilities.invokeLater(Main::new);
    }
}
