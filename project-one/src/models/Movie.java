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

    public Movie(int id, String title, int year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public String toString() {
        return String.format("%s (%d)", title, year);
    }
}
