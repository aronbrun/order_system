package admin;

import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;

public class Controller {

    private Model model = new Model();
    private File icon;

    @FXML
    private TextField itemTitle;

    @FXML
    private TextField itemPrice;

    @FXML
    private Label itemPath;

    @FXML
    private Label categoryPath;

    @FXML
    private ComboBox<String> categoryDropDown;

    @FXML
    private TextArea itemDescription;

    @FXML
    private TextField categoryTitle;

    // Creates Category on the Database
    @FXML
    void categoryCreate(ActionEvent event) {
        if(!categoryTitle.getText().isEmpty() && icon != null){
            model.createNewCategory(categoryTitle.getText(), icon);
            icon = null;
            categoryPath.setText("");
            categoryTitle.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Input and/or Image is empty");
        }
    }

    // FileChooser for Item Icon
    @FXML
    void itemFileChooser(ActionEvent event) {
        icon = model.openFileChooser();
        itemPath.setText(icon.getPath());
    }

    // FileChooser for Category Icon
    @FXML
    void itemCategoryChooser(ActionEvent event) {
        icon = model.openFileChooser();
        categoryPath.setText(icon.getPath());
    }

    // Creates a new Item on the Database
    @FXML
    void itemCreate(ActionEvent event) {
        StringBuilder emptyFields = new StringBuilder();

        if(itemTitle.getText().isEmpty())
            emptyFields.append("Title ");

        if(itemDescription.getText().isEmpty())
            emptyFields.append("Description ");

        if(itemPrice.getText().isEmpty())
            emptyFields.append("Price ");

        if(categoryDropDown.getSelectionModel().getSelectedItem() == null)
            emptyFields.append("Category ");

        if(icon == null)
            emptyFields.append("Image");

        if(emptyFields.toString().isEmpty()){
            try {
                model.createNewItem(categoryDropDown.getSelectionModel().getSelectedIndex() + 1, itemTitle.getText(), Integer.parseInt(itemPrice.getText()), itemDescription.getText(), icon);
                icon = null;
                itemPath.setText("");
                itemTitle.setText("");
                itemPrice.setText("");
                itemDescription.setText("");
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Field Price needs to be a number");
                emptyFields = new StringBuilder();
            }
        } else {
            JOptionPane.showMessageDialog(null, "The Field(s) " + emptyFields + " is/are empty");
        }
    }

    // Loads the Dropdown menu with the data from the Database/Model
    @FXML
    void itemCategory(MouseEvent event) {
        categoryDropDown.setItems(model.getCategories());
    }
}

