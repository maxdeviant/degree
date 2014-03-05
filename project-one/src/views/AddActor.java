/*
 *  Marshall Bowers
 *  CSC 417
 */

package views;

import controllers.ActorController;
import models.Actor;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class AddActor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel nameLabel;
    private JLabel birthYearLabel;
    private JFormattedTextField nameField;
    private JFormattedTextField birthYearField;
    private ActorController actorController;
    private DefaultListModel actorModel;

    /**
     * Creates a new AddActor dialog.
     * @param actorController An ActorController instance used to add the actor to the database.
     * @param actorModel The DefaultListModel corresponding to the actors JList.
     */
    public AddActor(ActorController actorController, DefaultListModel actorModel) {
        this.actorController = actorController;
        this.actorModel = actorModel;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Add Actor");

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
        // If both fields are not empty
        if (!(nameField.getText().equals("") || birthYearField.getText().equals(""))) {
            // Get the form values
            String name = nameField.getText();
            int birthYear = Integer.parseInt(birthYearField.getText());

            // Get the current year
            int currYear = Calendar.getInstance().get(Calendar.YEAR);

            // Check if the birth year is in bounds
            if (birthYear >= 1800 && birthYear <= currYear) {
                // Add the Actor to the table
                int id = actorController.addActor(name, birthYear);

                // Update the view
                actorModel.addElement(new Actor(id, name, birthYear));
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, String.format("Birth Year not in range. Must be between 1800 and %d", currYear), "Warning: Add Actor", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty. Actor not added.", "Warning: Add Actor", JOptionPane.WARNING_MESSAGE);
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
