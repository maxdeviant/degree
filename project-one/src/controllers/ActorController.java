package controllers;

import models.Actor;
import mysql.DataHandler;

import java.sql.ResultSet;
import java.util.LinkedHashSet;

public class ActorController {
    private DataHandler db;

    public ActorController(DataHandler db) {
        this.db = db;
    }

    public LinkedHashSet<Actor> getActors() {
        ResultSet results = db.read("select * from actor;");
        LinkedHashSet<Actor> set = new LinkedHashSet<Actor>();

        try {
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int birthYear = results.getInt("birth_year");

                set.add(new Actor(id, name, birthYear));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return set;
    }

    public String[] getActorNames() {
        ResultSet results = db.read("select * from actor;");
        LinkedHashSet<Actor> set = getActors();

        String[] names = new String[set.size()];

        int index = 0;
        for (Actor a : set) {
            names[index] = a.getName();
            index++;
        }

        return names;
    }
}
