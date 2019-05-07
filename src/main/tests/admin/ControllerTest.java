package admin;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

    private Controller controllerUnderTest;

    @Before
    public void setUp() {
        controllerUnderTest = new Controller();
    }

    @Test
    public void testCategoryCreate() {
        // Setup
        final ActionEvent event = null;

        // Run the test
        controllerUnderTest.categoryCreate(event);

        // Verify the results
    }

    @Test
    public void testItemFileChooser() {
        // Setup
        final ActionEvent event = null;

        // Run the test
        controllerUnderTest.itemFileChooser(event);

        // Verify the results
    }

    @Test
    public void testItemCategoryChooser() {
        // Setup
        final ActionEvent event = null;

        // Run the test
        controllerUnderTest.itemCategoryChooser(event);

        // Verify the results
    }

    @Test
    public void testItemCreate() {
        // Setup
        final ActionEvent event = null;

        // Run the test
        controllerUnderTest.itemCreate(event);

        // Verify the results
    }

    @Test
    public void testItemCategory() {
        // Setup
        final MouseEvent event = null;

        // Run the test
        controllerUnderTest.itemCategory(event);

        // Verify the results
    }
}
