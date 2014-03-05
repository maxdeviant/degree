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

    /**
     * Creates a new Actor with the given information.
     * @param id The ID of the Actor.
     * @param name The name of the Actor.
     * @param birthYear The birth year of the Actor.
     */
    public Actor(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    /**
     * Returns a String representation of the Actor. Note: This method is used to represent an Actor object in a JList, hence why it only returns the Actor's name.
     * @return A String representation of the Actor.
     */
    public String toString() {
        return name;
    }
}
