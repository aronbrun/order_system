package helperClasses;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class DBConnectionTest {

    private DBConnection dbConnectionUnderTest;

    @Before
    public void setUp() {
        dbConnectionUnderTest = new DBConnection();
        dbConnectionUnderTest.conn = mock(Connection.class);
    }

    @Test
    public void testClose() throws Exception {
        // Setup

        // Run the test
        dbConnectionUnderTest.close();

        // Verify the results
        verify(dbConnectionUnderTest.conn).close();
    }

    @Test
    public void testClose_ConnectionThrowsSQLException() throws Exception {
        // Setup
        doThrow(SQLException.class).when(dbConnectionUnderTest.conn).close();

        // Run the test
        dbConnectionUnderTest.close();

        // Verify the results
    }
}
