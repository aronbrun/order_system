package dethinne;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Main mainUnderTest;

    @Before
    public void setUp() {
        mainUnderTest = new Main();
    }

    @Test
    public void testStart() throws Exception {
        // Setup
        final Stage primaryStage = null;

        // Run the test
        mainUnderTest.start(primaryStage);

        // Verify the results
    }

    @Test(expected = Exception.class)
    public void testStart_ThrowsException() throws Exception {
        // Setup
        final Stage primaryStage = null;

        // Run the test
        mainUnderTest.start(primaryStage);
    }

    @Test
    public void testMain() {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        Main.main(args);

        // Verify the results
    }
}
