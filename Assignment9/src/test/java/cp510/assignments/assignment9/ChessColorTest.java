package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChessColorTest {

    @Test
    void testColor() {
        assertEquals("BLACK", ChessColor.BLACK.toString());
        assertEquals("WHITE", ChessColor.WHITE.toString());
    }

}
