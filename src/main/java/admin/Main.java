package admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import helperClasses.DBConnection;

public class Main extends Application {

    // Database Connection
    public static DBConnection dbConnection = new DBConnection();

    @Override
    public void start(Stage primaryStage) throws Exception{

        // JavaFX Stuff
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin.fxml"));
        primaryStage.setTitle("Admin Tool");
        primaryStage.setMinHeight(350);
        primaryStage.setMinWidth(250);
        primaryStage.setScene(new Scene(root, 240, 418));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
