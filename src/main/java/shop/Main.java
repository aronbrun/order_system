package shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../../resources/shop.fxml"));
        primaryStage.setTitle("Hello World");
=======
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
        primaryStage.setTitle("Shop");
>>>>>>> develop
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
