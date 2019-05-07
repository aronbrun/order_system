package admin;

import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ModelTest {

    private Model modelUnderTest;

    @Before
    public void setUp() {
        modelUnderTest = new Model();
    }

    @Test
    public void testCreateNewCategory() {
        // Setup
        final String categoryName = "categoryName";
        final File icon = null;

        // Run the test
        modelUnderTest.createNewCategory(categoryName, icon);

        // Verify the results
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
    public void testCreateNewItem() {
        // Setup
        final int idCategory = 0;
        final String title = "title";
        final int price = 0;
        final String description = "description";
        final File icon = null;

        // Run the test
        modelUnderTest.createNewItem(idCategory, title, price, description, icon);

        // Verify the results
    }

    @Test
    public void testOpenFileChooser() {
        // Setup
        final File expectedResult = null;

        // Run the test
        final File result = modelUnderTest.openFileChooser();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
