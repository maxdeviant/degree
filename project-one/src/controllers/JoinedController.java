/*
 *  Marshall Bowers
 *  CSC 417
 */

package controllers;

import mysql.DataHandler;

public class JoinedController {
    private DataHandler db;

    /**
     * Creates a new JoinedController with the given DataHandler.
     * @param db The DataHandler to be used.
     */
    public JoinedController(DataHandler db) {
        this.db = db;
    }

    public void join(int a, int m) {
        db.insert(String.format("insert into actor_movie (id, actor_id, movie_id) values (null, %d, %d);", a, m));
    }

    public void unjoin(int a, int m) {
        db.execute(String.format("delete from actor_movie where actor_id = %d and movie_id = %d;", a, m));
    }
}
