package views;

import controllers.ActorController;
import mysql.DataHandler;

import javax.swing.*;

public class Frame extends javax.swing.JFrame {
    private JPanel window;
    private JLabel actorsLabel;
    private JList actors;
    private DefaultListModel actorModel;
    private ActorController actorController;
    private JLabel moviesLabel;
    private JTable movies;

    public Frame() {
        // Form initialization
        JFrame frame = new JFrame("Main");
        frame.setContentPane(window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        init();
    }

    private void init() {
        DataHandler db = new DataHandler();

        actorModel = new DefaultListModel();

        for (String s : actorController.getActorNames()) {
            actorModel.addElement(s);
        }

//        actors.setModel();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
