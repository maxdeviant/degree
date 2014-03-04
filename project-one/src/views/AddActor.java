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

    private void onOK() {
        if (!(nameField.getText().equals("") || birthYearField.getText().equals(""))) {
            String name = nameField.getText();
            int birthYear = Integer.parseInt(birthYearField.getText());

            int currYear = Calendar.getInstance().get(Calendar.YEAR);

            if (birthYear >= 1800 && birthYear <= currYear) {
                int id = actorController.addActor(name, birthYear);
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

    private void onCancel() {
        dispose();
    }
}
