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

    public MovieController(DataHandler db) {
        this.db = db;
    }

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

    public String[] getMovieTitles() {
        LinkedHashSet<Movie> set = getMovies();

        ResultSet results = db.read("select * from movie;");

        String[] names = new String[set.size()];

        int index = 0;
        for (Movie m : set) {
            names[index] = m.getTitle();
            index++;
        }

        return names;
    }

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
