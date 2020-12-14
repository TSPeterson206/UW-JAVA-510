package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QueenTest {

    @Test
    void constructorTest() {
        Queen newQueen = new Queen(ChessColor.BLACK);
        assertTrue(newQueen instanceof Queen);
        assertEquals(ChessColor.BLACK, newQueen.getColor());
        assertEquals("queen", newQueen.getName());
    }

    @Test
    void validMovesTest() {

        Queen queen = new Queen(ChessColor.BLACK);

        ChessPoint queenPos = new ChessPoint(2, 2);

        ChessPieceMap map = new ChessPieceMap();

        map.put(queenPos, queen);

        assertEquals("[]", queen.getValidMoves(map).toString());
    }
}
