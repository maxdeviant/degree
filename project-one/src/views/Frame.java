package views;

import javax.swing.*;

public class Frame extends javax.swing.JFrame {
    private JLabel actorsLabel;
    private JLabel moviesLabel;
    private JList actors;
    private JTable movies;

    public Frame() {
        init();
    }

    private void init() {

    }

    public static void main(String[] args) {
        new Frame();
    }
}
