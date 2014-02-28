package models;

import java.sql.ResultSet;
import java.util.HashSet;

public abstract class Model<T> {
    public int getId() { return 0; }

    HashSet<T> load(ResultSet results) {
        return null;
    }

    void insert() {}
    void update() {}

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().isInstance(obj)) {
            return false;
        }
        return getId() == ((Model)obj).getId();
    }
}