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

    /**
     * Establishes a database connection with the default driver and database path.
     */
    public DataHandler() {
        this.driver = Properties.getDriver();
        this.database = Properties.getDatabase();

        connect();
    }

    /**
     * Connects to the database as root.
     */
    private void connect() {
        try {
            Class.forName(driver);

            connect = DriverManager.getConnection(database, Properties.getUsername(), Properties.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * Returns the results of an SQL query.
     * @param query The SQL query to be executed.
     * @return The ResultSet for the query.
     */
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

    /**
     * Executes an SQL query string.
     * @param query The SQL query to be executed.
     */
    public void execute(String query) {
        try {
            statement = connect.createStatement();

            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Executes an SQL query string and returns the keys.
     * @param query The SQL query to be executed.
     * @return The primary keys for the item(s) inserted.
     */
    public int insert(String query) {
        try {
            preparedStatement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.execute();

            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                return keys.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return -1;
    }

    /**
     * Closes the connection to the database.
     */
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