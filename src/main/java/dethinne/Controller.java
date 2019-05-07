package dethinne;

import dethinne.Model;
import helperClasses.DBConnection;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    private dethinne.Model model = new Model();

    @FXML
    private ListView<String> ready_list;

    @FXML
    private ListView<String> progress_list;

    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            ready_list.setItems(model.getReadyItems());
            progress_list.setItems(model.getNotReadyItems());
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ready_list.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();


            MenuItem editItem = new MenuItem();
            editItem.textProperty().bind(Bindings.format("Mark %s as resolved", cell.itemProperty()));
            editItem.setOnAction(event -> {
                String item = cell.getItem();
                model.markAsPickedUp(item);
            });

            contextMenu.getItems().addAll(editItem);

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });

        progress_list.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();


            MenuItem editItem = new MenuItem();
            editItem.textProperty().bind(Bindings.format("Mark %s as ready", cell.itemProperty()));
            editItem.setOnAction(event -> {
                String item = cell.getItem();
                model.markAsReady(item);
            });

            contextMenu.getItems().addAll(editItem);

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });

        Timer timer = new Timer();
        timer.schedule(task, 0, 3000);
    }

}