package controllers;

import models.Actor;
import mysql.DataHandler;

import java.sql.ResultSet;
import java.util.HashSet;

public class ActorController {
    private DataHandler db;

    public ActorController(DataHandler db) {
        this.db = db;
    }

    public HashSet<Actor> getActors(ResultSet results) {
        HashSet<Actor> set = new HashSet<Actor>();

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
        ResultSet results = db.read();
        HashSet<Actor> set = new HashSet<Actor>();

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

        String[] names = new String[set.size()];

        int index = 0;
        for (Actor a : set) {
            System.out.println(a.getName());
            names[index] = a.getName();
        }

        String[] test = {"a"};
        return test;
    }

    public String[] getActorNames(HashSet<Actor> set) {
        String[] names = new String[set.size()];

        int index = 0;
        for (Actor a : set) {
            names[index] = a.getName();
        }

        return names;
    }
}
