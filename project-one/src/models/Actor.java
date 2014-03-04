/*
 *  Marshall Bowers
 *  CSC 417
 */

package models;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.HashSet;

public class Actor extends Model {
    private int id;
    private String name;
    private int birthYear;

    public int getID() { return id; }
    public String getName() {
        return name;
    }
    public int getBirthYear() { return birthYear; }

    public Actor(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public HashSet<Actor> load(ResultSet results) {
        HashSet<Actor> set = new HashSet<Actor>();

        try {
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int birthYear = results.getInt("birthYear");

                set.add(new Actor(id, name, birthYear));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return set;
    }

    public String toString() {
        return name;
    }
}
