package dethinne;

import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Model modelUnderTest;

    @Before
    public void setUp() {
        modelUnderTest = new Model();
    }

    @Test
    public void testGetReadyItems() {
        // Setup
        final ObservableList<String> expectedResult = null;

        // Run the test
        final ObservableList<String> result = modelUnderTest.getReadyItems();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetNotReadyItems() {
        // Setup
        final ObservableList<String> expectedResult = null;

        // Run the test
        final ObservableList<String> result = modelUnderTest.getNotReadyItems();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMarkAsReady() {
        // Setup
        final String number = "number";

        // Run the test
        modelUnderTest.markAsReady(number);

        // Verify the results
    }

    @Test
    public void testMarkAsPickedUp() {
        // Setup
        final String number = "number";

        // Run the test
        modelUnderTest.markAsPickedUp(number);

        // Verify the results
    }
}
