package admin;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Admin Tool");
        primaryStage.setScene(new Scene(root, 240, 408));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
