package models;

public class Actor extends Model {
    private int id;
    private String name;
    private int birthYear;

    public Actor(int id, String name, int birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public String toString() {
        return String.format("ID: %s, Name: %s, Birth Year: %s", id, name, birthYear);
    }
}
