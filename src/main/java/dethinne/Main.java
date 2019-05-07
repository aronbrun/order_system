package dethinne;

import helperClasses.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static DBConnection dbConnection = new DBConnection();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(new File("C:\\Git\\order_system\\src\\main\\resources\\dethinne.fxml").toURI().toURL());
        primaryStage.setTitle("Dethinne");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("1");
        launch(args);
    }
}