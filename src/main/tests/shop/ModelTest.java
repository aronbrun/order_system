package shop;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Model modelUnderTest;

    @Before
    public void setUp() {
        modelUnderTest = new Model();
    }

    @Test
    public void testGetCategories() {
        // Setup
        final ObservableList<String> expectedResult = null;

        // Run the test
        final ObservableList<String> result = modelUnderTest.getCategories();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetIcons() {
        // Setup
        final Image[] expectedResult = new Image[]{};

        // Run the test
        final Image[] result = modelUnderTest.getIcons();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testSetItemGrid() {
        // Setup
        final GridPane grid = null;
        final String category = "category";
        final VBox cart = null;
        final Label label = null;

        // Run the test
        modelUnderTest.setItemGrid(grid, category, cart, label);

        // Verify the results
    }
}
