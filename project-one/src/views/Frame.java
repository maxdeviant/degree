package views;

import controllers.ActorController;
import controllers.MovieController;
import models.Actor;
import mysql.DataHandler;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends javax.swing.JFrame {
    private JPanel window;
    private JLabel actorsLabel;
    private JLabel moviesLabel;
    private JList actors;
    private JList movies;
    private DefaultListModel actorModel;
    private DefaultListModel movieModel;
    private ActorController actorController;
    private MovieController movieController;

    public Frame() {
        // Form initialization
        JFrame frame = new JFrame("Frame");
        frame.setContentPane(window);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        frame.setVisible(true);
    }

    private void init() {
        DataHandler db = new DataHandler();

        actorModel = new DefaultListModel();
        actors.setModel(actorModel);

        actorController = new ActorController(db);

        for (Actor a : actorController.getActors()) {
            actorModel.addElement(a);
        }

        movieModel = new DefaultListModel();
        movies.setModel(movieModel);

        movieController = new MovieController(db);

        for (String s : movieController.getMovieTitles()) {
            movieModel.addElement(s);
        }

        actors.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Actor actor = (Actor) actorModel.getElementAt(actors.getSelectedIndex());
                System.out.println(actorController.getJoined(actor));
            }
        });

        db.close();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
