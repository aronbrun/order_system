package helperClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    Connection conn;

    public DBConnection() {
        // Loads in Database Credentials from Properties File
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("Database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ip = properties.getProperty("ip");
        String table = properties.getProperty("table");
        String user = properties.getProperty("user");
        String pw = properties.getProperty("password");

        // Connects to local Database
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + table + "    ?serverTimezone=UTC", user, pw);
            System.out.println("Connected to the Database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to connect to the Database");
        }
    }

    // Method to get actual Connection
    public Connection getConn() {
        return conn;
    }

    // Closes Connection
    public void close(){
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
