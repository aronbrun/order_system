package progress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<String> ready_list;

    @FXML
    private ListView<String> progress_list;

    private ObservableList<String> ready_items = FXCollections.observableArrayList();
    private ObservableList<String> progess_items = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection Conn = null;

        try {
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system    ?serverTimezone=UTC", "root", "");
            System.out.println("Verbunden mit der Datenbank");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Verbindung zur Datenbank ist fehlgeschlagen.");
        }

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Conn.createStatement();

            rs = stmt.executeQuery("SELECT number FROM progress WHERE ready=true AND pickedup=false");
            while (rs.next()) {
                ready_items.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }

            rs = stmt.executeQuery("SELECT number FROM progress WHERE ready=false");
            while (rs.next()) {
                progess_items.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        ready_list.setItems(ready_items);
        progress_list.setItems(progess_items);

    }

}