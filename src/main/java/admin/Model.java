package admin;

import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private static DBConnection dbConnection = Main.dbConnection;
    private Statement statement;

    {
        try {
            statement = dbConnection.getConn().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewCategory(String categoryName){
        try {
            statement.executeUpdate("INSERT INTO category (Name) VALUES (\" " + categoryName + "\");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, categoryName + " created successfully");
    }

    public ObservableList<String> getCategories(){
        ResultSet rs = null;
        List<String> categories = new ArrayList<>();

        try {
            rs = statement.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                categories.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FXCollections.observableList(categories);
    }

    public void createNewItem(int idCategory, String title, int price, String description){
        try {
            System.out.println("INSERT INTO item (Order_idOrder, Category_idCategory, Title, Price, Description) VALUES (\"NULL\"," + idCategory + ",\"" + title + "\"," + price + ",\"" + description + "\");");
            statement.executeUpdate("INSERT INTO item (Order_idOrder, Category_idCategory, Title, Price, Description) VALUES (NULL," + idCategory + ",\"" + title + "\"," + price + ",\"" + description + "\");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, title + " created successfully");
    }
}
