package mysql;

import models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DataHandler {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String driver;
    private String database;

    public DataHandler() {
        this.driver = "com.mysql.jdbc.Driver";
        this.database = "jdbc:mysql://localhost/mymdb";
    }

    public DataHandler(String driver, String database) {
        this.driver = driver;
        this.database = database;
    }

    public Set<Model> read() {
        try {
            
        } catch (Exception e) {

        } finally {
            close();
            return null;
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
