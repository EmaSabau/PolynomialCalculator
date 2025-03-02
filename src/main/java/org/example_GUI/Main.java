package org.example_GUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            View myView = new View("Polynomial Calculator");
            myView.setVisible(true);
        });
    }
}
