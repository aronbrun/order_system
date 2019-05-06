package admin;

import com.cloudinary.Cloudinary;
import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
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

    public void createNewCategory(String categoryName, File icon){
        String path = icon.getPath().replace("\\", ";");
        try {
            statement.executeUpdate("INSERT INTO category (Name, Icon) VALUES (\"" + categoryName + "\", \"" + path + "\");");
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

    public void createNewItem(int idCategory, String title, int price, String description, File icon){
        String path = icon.getPath().replace("\\", ";");
        try {
            statement.executeUpdate("INSERT INTO item (Category_idCategory, Title, Price, Description, Icon) VALUES (" + idCategory + ",\"" + title + "\"," + price + ",\"" + description + "\",\"" + path + "\");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, title + " created successfully");
    }

    public File openFileChooser(){
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(null);
    }
}
