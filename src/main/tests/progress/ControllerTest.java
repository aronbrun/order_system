package progress;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

import static org.mockito.Mockito.mock;

public class ControllerTest {

    private Controller controllerUnderTest;

    @Before
    public void setUp() {
        controllerUnderTest = new Controller();
        controllerUnderTest.task = mock(TimerTask.class);
    }

    @Test
    public void testInitialize() {
        // Setup
        final URL location = null;
        final ResourceBundle resources = null;

        // Run the test
        controllerUnderTest.initialize(location, resources);

        // Verify the results
    }
}
