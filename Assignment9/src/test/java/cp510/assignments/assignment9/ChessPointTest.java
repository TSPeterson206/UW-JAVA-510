package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ChessPointTest {

    @Test
    void constructorTest() {
        ChessPoint point1 = new ChessPoint(3, 6);

        ChessPoint point2 = new ChessPoint(point1);
        ChessPoint point3 = new ChessPoint();

        assertEquals(point1, point2);
        assertEquals(0, point3.getCol());
        assertEquals(0, point3.getRow());

    }

    @Test
    void getAndSetRow() {
        ChessPoint point = new ChessPoint(3, 6);
        assertEquals(3, point.getRow());
        point.setRow(5);
        assertEquals(5, point.getRow());
    }

    @Test
    void getAndSetCol() {
        ChessPoint point = new ChessPoint(3, 6);
        assertEquals(6, point.getCol());
        point.setCol(7);
        assertEquals(7, point.getCol());
    }

    @Test
    void equalsTest() {
        ChessPoint point1 = new ChessPoint(3, 6);
        ChessPoint point2 = new ChessPoint(3, 6);
        ChessPoint point3 = new ChessPoint(3, 6);

        ChessPiece rook = new Rook(ChessColor.WHITE);

        assertTrue(point1.equals(point2));
        assertFalse(point1.equals(null));
        assertFalse(point1.equals(rook));
        point3.setCol(0);
        assertFalse(point1.equals(point3));
        point2.setRow(0);
        assertFalse(point1.equals(point2));

    }

    @Test
    void hashCodeTest() {
        ChessPoint point = new ChessPoint(3, 6);
        assertEquals(30, point.hashCode());
    }

    @Test
    void setPointTest() {
        ChessPoint point = new ChessPoint(3, 6);
        assertEquals(3, point.getRow());
        assertEquals(6, point.getCol());
        point.setPoint(5, 7);
        assertEquals(5, point.getRow());
        assertEquals(7, point.getCol());
    }

    @Test
    void addTest() {
        ChessPoint point = new ChessPoint(3, 6);
        assertTrue(point.add(0, 0));
        assertFalse(point.add(-6, 0));
        assertFalse(point.add(0, 8));
    }

    @Test
    void toStringTest() {
        ChessPoint point = new ChessPoint(3, 6);
        assertEquals("row = 3, column = 6", point.toString());
    }

}
