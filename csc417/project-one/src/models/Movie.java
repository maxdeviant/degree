/*
 *  Marshall Bowers
 *  CSC 417
 */

package models;

public class Movie extends Model {
    private int id;
    private String title;
    private int year;
    private String description;

    public int getID() { return id; }
    public String getTitle() {
        return title;
    }
    public int getYear() { return year; }
    public String getDescription() { return description; }

    /**
     * Creates a new Movie with the given information.
     * @param id The ID of the Movie.
     * @param title The title of the Movie.
     * @param year The year of the Movie.
     * @param description A description of the Movie.
     */
    public Movie(int id, String title, int year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }

    /**
     * Returns a String representation of the Movie. Note: This method is used to represent an Movie object in a JList, hence why it returns the formatted title and year of the Movie.
     * @return A String representation of the Movie.
     */
    public String toString() {
        return String.format("%s (%d)", title, year);
    }
}
