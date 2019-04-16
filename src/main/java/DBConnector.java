import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public void startConnection(){
        Connection Conn = null;

        try {
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system    ?serverTimezone=UTC", "root", "");
            System.out.println("Verbunden mit der Datenbank");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Verbindung zur Datenbank ist fehlgeschlagen.");
        }

    }

    public static void main(String[] args){
        
    }
}
