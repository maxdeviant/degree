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

public class ActorController {
    private DataHandler db;

    /**
     * Creates a new ActorController with the given DataHandler.
     * @param db The DataHandler to be used.
     */
    public ActorController(DataHandler db) {
        this.db = db;
    }

    /**
     * Adds a new actor to the actor table.
     * @param name The name of the actor being added.
     * @param birthYear The birth year of the actor being added.
     * @return The primary key of the actor.
     */
    public int addActor(String name, int birthYear) {
        return db.insert(String.format("insert into actor (id, name, birthYear) values (null, '%s', '%d');", name, birthYear));
    }

    /**
     * Removes an actor from the actor table.
     * @param id The ID of the actor to remove.
     */
    public void removeActor(int id) {
        db.execute(String.format("delete from actor where id = %d;", id));
        db.execute(String.format("delete from actor_movie where actor_id = %d;", id));
    }

    /**
     * Gets all of the entries from the actor table.
     * @return A set of Actors.
     */
    public LinkedHashSet<Actor> getActors() {
        LinkedHashSet<Actor> set = new LinkedHashSet<Actor>();

        ResultSet results = db.read("select * from actor;");

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

    /**
     * Gets all the movies associated with an actor, using the joined actor_movie table.
     * @param actor The actor to retrieve movies for.
     * @return A set of Movies associated with the given Actor.
     */
    public LinkedHashSet<Movie> getJoined(Actor actor) {
        LinkedHashSet<Movie> set = new LinkedHashSet<Movie>();
        HashSet<Integer> list = new HashSet<Integer>();

        String query = String.format("select * from actor_movie where actor_id = %d", actor.getID());
        ResultSet results = db.read(query);

        try {
            while (results.next()) {
                int movieID = results.getInt("movie_id");

                ResultSet movie = db.read(String.format("select * from movie where id = %d;", movieID));

                while (movie.next()) {
                    int id = movie.getInt("id");
                    String title = movie.getString("title");
                    int year = movie.getInt("year");
                    String description = movie.getString("description");

                    set.add(new Movie(id, title, year, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return set;
    }
}
