package shop;

import admin.Main;
import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    // making db connection
    private static DBConnection dbConnection = Main.dbConnection;
    private Statement statement;

    {
        try {
            statement = dbConnection.getConn().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // getting names of categories from db
    public ObservableList<String> getCategories(){
        ResultSet rs = null;
        List<String> categories = new ArrayList<>();

        try {
            rs = statement.executeQuery("SELECT * FROM Category");
            while (rs.next()) {
                categories.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FXCollections.observableList(categories);
    }
    // getting icons of categories from db
    public Image[] getIcons(){
        ResultSet rs = null;
        List<Image> categories = new ArrayList<>();

        try {
            rs = statement.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                Image image = new Image(rs.getString(3));
                categories.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Image[] itemsArray = new Image[categories.size()];
        itemsArray = categories.toArray(itemsArray);
        return itemsArray;
    }
    // getting all icons and assigning them to grid
    public void setItemGrid(GridPane grid, String category, VBox cart){
        ResultSet rs = null;

        String title;
        String price;
        Image icon;
        int i = 0;
        int y = 0;
        try {
            String stment = "SELECT * FROM Item i JOIN Category c ON i.Category_idCategory = c.idCategory WHERE c.Name = '" + category + "'";
            PreparedStatement preparedStatement = dbConnection.getConn().prepareStatement(stment);
            rs = preparedStatement.executeQuery(stment);
            while (rs.next()) {
                if(i >= 4){
                    i = 0;
                    y++;
                }
                title = rs.getString(3);
                price = rs.getString(4);
                icon = new Image(rs.getString(6));
                ImageView imgView = new ImageView(icon);
                ImageView imgView2 = new ImageView(icon);
                final String title_ = title;
                imgView.setOnMouseClicked((MouseEvent e) -> {
                    cart.setPadding(new Insets(0, 0, 0, 30));
                    try {
                        cart.getChildren().add(imgView2);
                    }catch (IllegalArgumentException e1) {
                        cart.getChildren().get(1).setAccessibleText("lol");
                    }
                    cart.getChildren().add(new Text(title_));
                });
                VBox vbox = new VBox();
                vbox.setPadding(new Insets(10, 0, 0, 20));
                vbox.getChildren().add(new Text("          " + price + "CHF"));
                vbox.getChildren().add(imgView);
                vbox.getChildren().add(new Text(title));

                grid.add(vbox, i, y);
                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
