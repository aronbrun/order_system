package shop;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ResourceBundle;

import static org.mockito.Mockito.*;

public class ControllerTest {

    private Controller controllerUnderTest;

    @Before
    public void setUp() {
        controllerUnderTest = new Controller();
        controllerUnderTest.iconList = mock(ListView.class);
        controllerUnderTest.cartBox = mock(VBox.class);
        controllerUnderTest.itemGrid = mock(GridPane.class);
        controllerUnderTest.checkOut = mock(Button.class);
        controllerUnderTest.totalAmount = mock(Label.class);
    }

    @Test
    public void testInitialize() {
        // Setup
        final URL location = null;
        final ResourceBundle resources = null;
        when(controllerUnderTest.iconList.getSelectionModel()).thenReturn(null);
        when(controllerUnderTest.itemGrid.getChildren()).thenReturn(null);

        // Run the test
        controllerUnderTest.initialize(location, resources);

        // Verify the results
        verify(controllerUnderTest.iconList).setItems(null);
        verify(controllerUnderTest.iconList).setCellFactory(null);
        verify(controllerUnderTest.iconList).setOnMouseClicked(null);
        verify(controllerUnderTest.checkOut).setOnAction(null);
    }
}
