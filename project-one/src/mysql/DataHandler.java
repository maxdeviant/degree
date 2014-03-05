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

        connect();
    }

    public DataHandler(String driver, String database) {
        this.driver = driver;
        this.database = database;
    }

    private void connect() {
        try {
            Class.forName(driver);

            connect = DriverManager.getConnection(database, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet read(String query) {
        try {
            statement = connect.createStatement();

            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultSet;
    }

    public void execute(String query) {
        try {
            statement = connect.createStatement();

            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int insert(String query) {
        try {
            preparedStatement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.execute();

            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                System.out.println(keys.getInt(1));
                return keys.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return -1;
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