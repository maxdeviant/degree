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

    private void onOK() {
        if (!(titleField.getText().length() < 3 || yearField.getText().equals(""))) {
            String title = titleField.getText();
            int year = Integer.parseInt(yearField.getText());

            int currYear = Calendar.getInstance().get(Calendar.YEAR);

            if (year >= 1900 && year <= currYear) {
                int id = movieController.addMovie(title, year);
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

    private void onCancel() {
        dispose();
    }
}

