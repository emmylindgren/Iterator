package se.umu.cs.emli;
import javax.swing.*;

/**
 * Main class for testiterator.
 * @author Emmy Lindgren, id19eln.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Controller::new);
    }
}