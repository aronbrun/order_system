package progress;

import progress.Model;
import helperClasses.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private progress.Model model = new Model();

    @FXML
    private ListView<String> ready_list;

    @FXML
    private ListView<String> progress_list;

    private ObservableList<String> ready_items = FXCollections.observableArrayList();
    private ObservableList<String> progess_items = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ready_list.setItems(model.getReadyItems());
        progress_list.setItems(model.getNotReadyItems());
    }

}