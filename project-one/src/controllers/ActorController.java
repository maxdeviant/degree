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

    public ActorController(DataHandler db) {
        this.db = db;
    }

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

    public String[] getActorNames() {
        LinkedHashSet<Actor> set = getActors();

        ResultSet results = db.read("select * from actor;");

        String[] names = new String[set.size()];

        int index = 0;
        for (Actor a : set) {
            names[index] = a.getName();
            index++;
        }

        return names;
    }

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
