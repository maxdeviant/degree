/*
 *  Marshall Bowers
 *  CSC 417
 */

package mysql;

import javax.swing.*;
import java.sql.*;

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

    public ResultSet read(String query) {
        try {
            // Load the MySQL driver
            Class.forName(driver);

            connect = DriverManager.getConnection(database, "root", "");

            statement = connect.createStatement();

            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
//            close();
        }

        return resultSet;
    }

    public void close() {
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
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}