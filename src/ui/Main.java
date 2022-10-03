package ui;

import javax.swing.*;

public class Main extends JFrame {

    Main(){
        super("Enki");

        add(Screen.getInstance());

        //Les détails de création de ma fenêtre
        setLocation(1000, 250);
        setSize(400, 250);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
