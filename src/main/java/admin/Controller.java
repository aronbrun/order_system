package admin;

import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class Controller {

    private Model model = new Model();

    @FXML
    private TextField itemTitle;

    @FXML
    private TextField itemPrice;

    @FXML
    private ComboBox<String> categoryDropDown;

    @FXML
    private TextArea itemDescription;

    @FXML
    private TextField categoryTitle;

    @FXML
    void categoryCreate(ActionEvent event) {
        if(!categoryTitle.getText().isEmpty()){
            model.createNewCategory(categoryTitle.getText());
            categoryTitle.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Input is empty");
        }
    }

    @FXML
    void itemCreate(ActionEvent event) {
        StringBuilder emptyFields = new StringBuilder();

        if(itemTitle.getText().isEmpty())
            emptyFields.append("Title ");

        if(itemDescription.getText().isEmpty())
            emptyFields.append("Description ");

        if(itemPrice.getText().isEmpty())
            emptyFields.append("Price ");

        if(categoryDropDown.getSelectionModel().getSelectedItem().isEmpty())
            emptyFields.append("Category ");

        if(emptyFields.toString().isEmpty()){
            model.createNewItem(categoryDropDown.getSelectionModel().getSelectedIndex(), itemTitle.getText(), Integer.parseInt(itemPrice.getText()), itemDescription.getText());
        } else {
            JOptionPane.showMessageDialog(null, "The Field(s) " + emptyFields + " is/are empty");
        }

    }

    @FXML
    void itemCategory(MouseEvent event) {
        categoryDropDown.setItems(model.getCategories());
    }
}

