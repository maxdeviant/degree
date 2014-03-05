/*
 *  Marshall Bowers
 *  CSC 417
 */

package views;

import controllers.MovieController;
import models.Movie;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class AddMovie extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel titleLabel;
    private JLabel yearLabel;
    private JFormattedTextField titleField;
    private JFormattedTextField yearField;
    MovieController movieController;
    DefaultListModel movieModel;

    /**
     * Creates a new AddMovie dialog.
     * @param movieController A MovieController instance used to add the movie to the database.
     * @param movieModel The DefaultListModel corresponding to the movies JList.
     */
    public AddMovie(MovieController movieController, DefaultListModel movieModel) {
        this.movieController = movieController;
        this.movieModel = movieModel;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Add Movie");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Called when the OK button is clicked.
     */
    private void onOK() {
        // If the title is at least 3 characters and the year is not empty
        if (!(titleField.getText().length() < 3 || yearField.getText().equals(""))) {
            // Get the form values
            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());

            // Get the current year
            int currYear = Calendar.getInstance().get(Calendar.YEAR);

            // If the year is in bounds
            if (year >= 1900 && year <= currYear) {
                // Add the movie to the table
                int id = movieController.addMovie(title, year);

                // Update the view
                movieModel.addElement(new Movie(id, title, year, ""));
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, String.format("Year not in range. Must be between 1900 and %d", currYear), "Warning: Add Movie", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty and title must be longer than 3 characters. Movie not added.", "Warning: Add Movie", JOptionPane.WARNING_MESSAGE);
        }

        dispose();
    }

    /**
     * Called when the Cancel button is clicked.
     */
    private void onCancel() {
        dispose();
    }
}

