package mysql;

import models.*;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

    public ResultSet read() {
        try {
            // Load the MySQL driver
            Class.forName(driver);

            connect = DriverManager.getConnection(database, "root", "");

            statement = connect.createStatement();

            resultSet = statement.executeQuery("select * from actor;");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            close();
        }

        return resultSet;
    }

//    public HashMap<Integer, Object> read() {
//        HashMap<Integer, Object> results = new HashMap<Integer, Object>();
//
//        try {
//            // Load the MySQL driver
//            Class.forName(driver);
//
//            connect = DriverManager.getConnection(database, "root", "");
//
//            statement = connect.createStatement();
//
//            resultSet = statement.executeQuery("select * from actor;");
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int birthYear = resultSet.getInt("birth_year");
//
//                results.put(id, new Actor(id, name, birthYear));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            close();
//            return results;
//        }
//    }

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
