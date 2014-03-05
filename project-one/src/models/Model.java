/*
 *  Marshall Bowers
 *  CSC 417
 */

package models;

import java.sql.ResultSet;
import java.util.HashSet;

public abstract class Model<T> {
    HashSet<T> load(ResultSet results) {
        return null;
    }

    void insert() {}
    void update() {}
    void remove() {}
}