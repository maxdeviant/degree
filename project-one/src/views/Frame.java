package views;

import controllers.ActorController;
import controllers.MovieController;
import models.Actor;
import models.Movie;
import mysql.DataHandler;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashSet;

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

        actors.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Actor actor = (Actor) actorModel.getElementAt(actors.getSelectedIndex());
                LinkedHashSet<Movie> joined = actorController.getJoined(actor);

                movies.clearSelection();

                for (Movie m : joined) {
                    movies.getSelectionModel().addSelectionInterval(m.getID() - 1, m.getID() - 1);
                }
            }
        });

        movieModel = new DefaultListModel();
        movies.setModel(movieModel);

        movieController = new MovieController(db);

        for (Movie m : movieController.getMovies()) {
            movieModel.addElement(m);
        }

        movies.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Movie movie = (Movie) movieModel.getElementAt(movies.getSelectedIndex());
                LinkedHashSet<Actor> joined = movieController.getJoined(movie);

                actors.clearSelection();

                for (Actor a : joined) {
                    actors.getSelectionModel().addSelectionInterval(a.getID() - 1, a.getID() - 1);
                }
            }
        });

        db.close();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
