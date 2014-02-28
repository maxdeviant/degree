package main;

import models.Actor;
import models.Model;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    private JPanel window;
    private JList actors;
    private JTextArea info;
    private JTable movies;

    public static void main(String[] args) {
        // Form initialization
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        dbTest();
    }

    public static void dbTest() {
        mysql.DataHandler data = new mysql.DataHandler();

        for (Object o : data.read().values()) {
            System.out.println(o.toString());
        }
    }
}

