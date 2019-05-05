package admin;

import helperClasses.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private static DBConnection dbConnection = Main.dbConnection;

    @FXML
    private TextField itemTitle;

    @FXML
    private TextField itemPrice;

    @FXML
    private TextArea itemDescription;

    @FXML
    private TextField categoryTitle;

    @FXML
    void categoryCreate(ActionEvent event) {
        
    }

    @FXML
    void iteamCreate(ActionEvent event) {

    }

    @FXML
    void itemCategory(ActionEvent event) {

    }

}

