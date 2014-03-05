/*
 *  Marshall Bowers
 *  CSC 417
 */

package controllers;

import models.Actor;
import models.Movie;
import mysql.DataHandler;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MovieController {
    private DataHandler db;

    /**
     * Creates a new MovieController with the given DataHandler
     * @param db The DataHandler to be used.
     */
    public MovieController(DataHandler db) {
        this.db = db;
    }

    /**
     * Adds a new movie to the movie table.
     * @param title The title of the movie being added.
     * @param year The year of the movie being added.
     * @return The primary key of the movie.
     */
    public int addMovie(String title, int year) {
        return db.insert(String.format("insert into movie (id, title, year, description) values (null, '%s', '%d', '');", title, year));
    }

    /**
     * Updates an existing movie in the movie table.
     * @param id The ID of the movie to update.
     * @param description A new description for the movie.
     */
    public void updateMovie(int id, String description) {
        db.execute(String.format("update movie set description = '%s' where id = %d;", description, id));
    }

    /**
     * Removes a movie from the movie table.
     * @param id The ID of the movie to remove.
     */
    public void removeMovie(int id) {
        db.execute(String.format("delete from movie where id = %d;", id));
        db.execute(String.format("delete from actor_movie where movie_id = %d;", id));
    }

    /**
     * Gets all of the entries from the movie table.
     * @return A set of Movies.
     */
    public LinkedHashSet<Movie> getMovies() {
        LinkedHashSet<Movie> set = new LinkedHashSet<Movie>();

        ResultSet results = db.read("select * from movie;");

        try {
            while (results.next()) {
                int id = results.getInt("id");
                String title = results.getString("title");
                int year = results.getInt("year");
                String description = results.getString("description");

                set.add(new Movie(id, title, year, description));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return set;
    }

    /**
     * Gets all the actors associated with a movie, using the joined actor_movie table.
     * @param movie The movie to retrieve actors from.
     * @return A set of Actors associated with the given Movie.
     */
    public LinkedHashSet<Actor> getJoined(Movie movie) {
        LinkedHashSet<Actor> set = new LinkedHashSet<Actor>();
        HashSet<Integer> list = new HashSet<Integer>();

        String query = String.format("select * from actor_movie where movie_id = %d", movie.getID());
        ResultSet results = db.read(query);

        try {
            while (results.next()) {
                int actorID = results.getInt("actor_id");

                ResultSet actor = db.read(String.format("select * from actor where id = %d;", actorID));

                while (actor.next()) {
                    int id = actor.getInt("id");
                    String name = actor.getString("name");
                    int birthYear = actor.getInt("birthYear");

                    set.add(new Actor(id, name, birthYear));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return set;
    }
}
