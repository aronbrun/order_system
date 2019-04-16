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

        System.out.println(table);

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + table+ "    ?serverTimezone=UTC", user, pw);
            System.out.println("Verbunden mit der Datenbank");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Verbindung zur Datenbank ist fehlgeschlagen.");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void close(){
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
