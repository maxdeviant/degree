package controllers;

import models.Movie;
import mysql.DataHandler;

import java.sql.ResultSet;
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
}
