package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class KnightTest {

    @Test
    void constructorTest() {
        Knight newKnight = new Knight(ChessColor.BLACK);
        assertTrue(newKnight instanceof Knight);
        assertEquals(ChessColor.BLACK, newKnight.getColor());
        assertEquals("knight", newKnight.getName());
    }

    @Test
    void validMovesTest() {

        Knight knight = new Knight(ChessColor.BLACK);

        ChessPoint knightPos = new ChessPoint(2, 2);

        ChessPieceMap map = new ChessPieceMap();

        map.put(knightPos, knight);

        assertEquals("[]", knight.getValidMoves(map).toString());
    }
}
