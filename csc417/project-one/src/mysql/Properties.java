/*
 *  Marshall Bowers
 *  CSC 417
 */

package mysql;

public class Properties {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "jdbc:mysql://localhost/mymdb";
    private static String username = "root";
    private static String password = "";

    public static String getDriver() {
        return driver;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
