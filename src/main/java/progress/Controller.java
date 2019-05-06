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
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    private progress.Model model = new Model();

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
        Timer timer = new Timer();
        timer.schedule(task, 0, 3000);
    }

}