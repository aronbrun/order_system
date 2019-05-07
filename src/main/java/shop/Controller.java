package shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // generating variables for Controller
    public Model model = new Model();
    @FXML
    ListView<String> iconList = new ListView<String>();
    @FXML
    VBox cartBox = new VBox();
    @FXML
    GridPane itemGrid = new GridPane();
    @FXML
    Button checkOut = new Button();
    @FXML
    Label totalAmount = new Label();

    private Image[] listOfImages = model.getIcons();
    public String selectedCategory = "";

    // intitalize method for fxml file
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> items = model.getCategories();
        iconList.setItems(items);

        iconList.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("burger"))
                        imageView.setImage(listOfImages[0]);
                    else if(name.equals("menu"))
                        imageView.setImage(listOfImages[1]);
                    else if(name.equals("drink"))
                        imageView.setImage(listOfImages[2]);
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });
        // selecting the first item
        iconList.getSelectionModel().select(0);
        selectedCategory = iconList.getSelectionModel().getSelectedItem();
        model.setItemGrid(itemGrid, selectedCategory, cartBox, totalAmount);

        iconList.setOnMouseClicked((MouseEvent e) -> {
            itemGrid.getChildren().clear();
            selectedCategory = iconList.getSelectionModel().getSelectedItem();
            model.setItemGrid(itemGrid, selectedCategory, cartBox, totalAmount);
        });
        checkOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Please proceed to pay at your counter");
            }
        });
    }
}
