package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class KingTest {

    @Test
    void constructorTest() {
        King newKing = new King(ChessColor.BLACK);
        assertTrue(newKing instanceof King);
        assertEquals(ChessColor.BLACK, newKing.getColor());
        assertEquals("king", newKing.getName());
    }

    @Test
    void validMovesTest() {

        King king = new King(ChessColor.BLACK);

        ChessPoint kingPos = new ChessPoint(2, 2);

        ChessPieceMap map = new ChessPieceMap();

        map.put(kingPos, king);

        assertEquals("[]", king.getValidMoves(map).toString());
    }

}
