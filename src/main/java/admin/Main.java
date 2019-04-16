package admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import helperClasses.DBConnection;

public class Main extends Application {

    public static DBConnection dbConnection = new DBConnection();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin.fxml"));
        primaryStage.setTitle("Admin Tool");
        primaryStage.setScene(new Scene(root, 240, 408));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
