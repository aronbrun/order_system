package dethinne;

import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private static DBConnection dbConnection = Main.dbConnection;
    private Statement statement;
    private ResultSet rs;

    {
        try {
            statement = dbConnection.getConn().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> getReadyItems(){
        ObservableList<String> items = FXCollections.observableArrayList();;
        try {
            rs = statement.executeQuery("SELECT idOrder FROM `order` WHERE ready=true AND pickedup=false");
            while (rs.next()) {
                items.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return items;
    }

    public ObservableList<String> getNotReadyItems(){
        ObservableList<String> items = FXCollections.observableArrayList();;
        try {
            rs = statement.executeQuery("SELECT idOrder FROM `order` WHERE ready=false");
            while (rs.next()) {
                items.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return items;
    }

    public void markAsReady(String number){
        try {
            statement.executeUpdate("UPDATE `order` SET Ready = 1, PickedUp = 0 WHERE idOrder=" + number + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void markAsPickedUp(String number){
        try {
            statement.executeUpdate("UPDATE `order` SET Ready = 1, PickedUp = 1 WHERE idOrder=" + number + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
