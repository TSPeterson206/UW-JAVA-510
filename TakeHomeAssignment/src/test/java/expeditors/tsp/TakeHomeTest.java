package expeditors.tsp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * The TakeHomeTest class for testing the classes for the Expeditors Take Home
 * Assignment.
 * 
 * @author Toby Peterson.
 *
 */
public class TakeHomeTest {

    private Driver driver;

    /**
     * The setup test.
     */
    @Before
    public void setup() {
        driver = new Driver();
        assertTrue(driver.getClass().equals(Driver.class));
    }

    /**
     * The inputDataTest test.
     */
    @Test
    public void inputDataTest() {
        assertEquals(10, Driver.getInputStrings().length);
        assertTrue(Driver.getInputStrings() instanceof String[][]);
    }

    /**
     * The testingExcIfNoHashmapCreated test.
     */
    @Test
    public void testingExcIfNoHashmapCreated() {
        Assertions.assertThrows(NullPointerException.class, new Executable() {
            @SuppressWarnings("static-access")
            public void execute() throws Throwable {
                driver.print();
            }
        });
    }
}
