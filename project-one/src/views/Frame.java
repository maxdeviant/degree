/*
 *  Marshall Bowers
 *  CSC 417
 */

package views;

import controllers.ActorController;
import controllers.JoinedController;
import controllers.MovieController;
import models.Actor;
import models.Movie;
import mysql.DataHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashSet;

public class Frame extends javax.swing.JFrame {
    private JPanel window;
    private JMenuBar menuBar;
    private JMenu actorMenu;
    private JMenu movieMenu;
    private JCheckBoxMenuItem joinedState;
    private JLabel actorsLabel;
    private JLabel moviesLabel;
    private JLabel infoLabel;
    private JLabel joinedLabel;
    private JList actors;
    private JList movies;
    private JTextPane info;
    private JList joined;
    private DefaultListModel actorModel;
    private DefaultListModel movieModel;
    private DefaultListModel joinedModel;
    private ActorController actorController;
    private MovieController movieController;
    private JoinedController joinedController;

    public Frame() {
        // Form initialization
        JFrame frame = new JFrame("Frame");
        frame.setContentPane(window);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the form elements
        init();

        // Add the menu to the frame
        menu(frame);
        frame.setJMenuBar(menuBar);

        // Make the frame visible
        frame.setVisible(true);
    }

    /**
     * Initializes all of the form elements.
     */
    private void init() {
        // Instantiate a new DataHandler for accessing the database
        DataHandler db = new DataHandler();

        // Declare the JList models
        actorModel = new DefaultListModel();
        movieModel = new DefaultListModel();
        joinedModel = new DefaultListModel();

        // Associate the models with their respective lists
        actors.setModel(actorModel);
        movies.setModel(movieModel);
        joined.setModel(joinedModel);

        // Instantiate the controllers with the database
        actorController = new ActorController(db);
        movieController = new MovieController(db);
        joinedController = new JoinedController(db);

        // Initialize the Actor list with elements from the database
        for (Actor a : actorController.getActors()) {
            actorModel.addElement(a);
        }

        // Add a mouse listener for the Actor list
        actors.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Actor actor = (Actor) actorModel.getElementAt(actors.getSelectedIndex());
                LinkedHashSet<Movie> joined = actorController.getJoined(actor);

//                movies.clearSelection();
                joinedModel.clear();

                // Change labels and set actor information
                infoLabel.setText("Information");
                joinedLabel.setText("Filmography");
                info.setText(String.format("Name: %s\nBorn: %d", actor.getName(), actor.getBirthYear()));

                int mIndex = movies.getSelectedIndex();
                joinedState.setState(false);

                // Populate the Filmography list
                for (Movie m : joined) {
//                    movies.getSelectionModel().addSelectionInterval(m.getID() - 1, m.getID() - 1);
                    joinedModel.addElement(m);

                    if (mIndex != -1) {
                        if (m.getID() == ((Movie) movieModel.getElementAt(mIndex)).getID()) {
                            joinedState.setState(true);
                        }
                    }
                }
            }
        });

        // Initialize the Movie list with elements from the database
        for (Movie m : movieController.getMovies()) {
            movieModel.addElement(m);
        }

        // Add a mouse listener for the Movie list
        movies.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Movie movie = (Movie) movieModel.getElementAt(movies.getSelectedIndex());
                LinkedHashSet<Actor> joined = movieController.getJoined(movie);

//                actors.clearSelection();
                joinedModel.clear();

                // Change labels and set movie description
                infoLabel.setText("Description");
                joinedLabel.setText("Cast List");
                info.setText(movie.getDescription());

                int aIndex = actors.getSelectedIndex();
                joinedState.setState(false);

                // Populate the Cast list
                for (Actor a : joined) {
//                    actors.getSelectionModel().addSelectionInterval(a.getID() - 1, a.getID() - 1);
                    joinedModel.addElement(a);

                    if (aIndex != -1) {
                        if (a.getID() == ((Actor) actorModel.getElementAt(aIndex)).getID()) {
                            joinedState.setState(true);
                        }
                    }
                }
            }
        });
    }

    /**
     * Initialize and handle input to the menu.
     * @param parent The parent JFrame.
     */
    private void menu(final JFrame parent) {
        // Declare the menus
        menuBar = new JMenuBar();
        actorMenu = new JMenu("Actor");
        movieMenu = new JMenu("Movie");

        // Add the submenus to the main menu
        menuBar.add(actorMenu);
        menuBar.add(movieMenu);

        // Declare options for the Actor menu
        JMenuItem addActor = new JMenuItem("Add Actor");
        JMenuItem removeActor = new JMenuItem("Remove Actor");

        // Add options to the Actor menu
        actorMenu.add(addActor);
        actorMenu.add(removeActor);

        // Add an action listener for the 'Add Actor' option
        addActor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the AddActor dialog
                AddActor dialog = new AddActor(actorController, actorModel);
                dialog.pack();
                dialog.setLocationRelativeTo(parent);
                dialog.setVisible(true);
            }
        });

        // Add an action listener for the 'Remove Actor' option
        removeActor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make sure an Actor is selected
                if (actors.getSelectedValue() != null) {
                    // Confirm the deletion
                    int result = JOptionPane.showConfirmDialog(parent, String.format("Are you sure you wish to delete %s?", actors.getSelectedValue()), "Remove Actor", JOptionPane.WARNING_MESSAGE);

                    // If the user chose OK
                    if (result == JOptionPane.YES_OPTION) {
                        // Remove the Actor from the table
                        Actor a = (Actor) actors.getSelectedValue();
                        actorController.removeActor(a.getID());

                        // Update the view
                        actorModel.removeElement(actorModel.getElementAt(actors.getSelectedIndex()));
                        dispose();
                    } else {
                        dispose();
                    }
                }
            }
        });

        // Declare options for the Movie menu
        JMenuItem addMovie = new JMenuItem("Add Movie");
        JMenuItem modifyMovie = new JMenuItem("Edit Description");
        JMenuItem removeMovie = new JMenuItem("Remove Movie");

        // Add options to the Movie menu
        movieMenu.add(addMovie);
        movieMenu.add(modifyMovie);
        movieMenu.add(removeMovie);

        // Add an action listener for the 'Add Movie' option
        addMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the AddMovie dialog
                AddMovie dialog = new AddMovie(movieController, movieModel);
                dialog.pack();
                dialog.setLocationRelativeTo(parent);
                dialog.setVisible(true);
            }
        });

        // Add an action listener for the 'Edit Description' option
        modifyMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make sure a Movie is selected
                if (movies.getSelectedValue() != null) {
                    // Show the input dialog
                    String input = JOptionPane.showInputDialog(parent, String.format("Description: "), "Edit Description", JOptionPane.NO_OPTION);

                    // Modify the movie description
                    Movie m = (Movie) movies.getSelectedValue();
                    movieController.updateMovie(m.getID(), input);

                    // Update the view
                    m = new Movie(m.getID(), m.getTitle(), m.getYear(), input);
                    movieModel.setElementAt(m, movies.getSelectedIndex());
                    info.setText(m.getDescription());
                    dispose();
                }
            }
        });

        // Add an action listener for the 'Remove Movie' option
        removeMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Make sure a Movie is selected
                if (movies.getSelectedValue() != null) {
                    // Confirm the deletion
                    int result = JOptionPane.showConfirmDialog(parent, String.format("Are you sure you wish to delete %s?", movies.getSelectedValue()), "Remove Movie", JOptionPane.WARNING_MESSAGE);

                    // If the user chose OK
                    if (result == JOptionPane.YES_OPTION) {
                        // Remove the Movie from the table
                        Movie m = (Movie) movies.getSelectedValue();
                        movieController.removeMovie(m.getID());

                        // Update the view
                        movieModel.removeElement(movieModel.getElementAt(movies.getSelectedIndex()));
                        dispose();
                    } else {
                        dispose();
                    }
                }
            }
        });

        // Declare options for the joined menu
        joinedState = new JCheckBoxMenuItem("Joined");

        // Add options to the joined menu
        menuBar.add(joinedState);

        joinedState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(actors.getSelectedIndex() == -1 || movies.getSelectedIndex() == -1)) {
                    if (joinedState.getState()) {
                        int a = ((Actor) actorModel.getElementAt(actors.getSelectedIndex())).getID();
                        int m = ((Movie) movieModel.getElementAt(movies.getSelectedIndex())).getID();

                        joinedController.join(a, m);
                    } else {
                        int a = ((Actor) actorModel.getElementAt(actors.getSelectedIndex())).getID();
                        int m = ((Movie) movieModel.getElementAt(movies.getSelectedIndex())).getID();
                        
                        joinedController.unjoin(a, m);
                    }
                } else {
                    joinedState.setState(joinedState.getState() ? false : true);
                }
            }
        });

    }

    public static void main(String[] args) {
        // Create a new application instance
        new Frame();
    }
}
