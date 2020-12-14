package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    void constructorTest() {
        Pawn newPawn = new Pawn(ChessColor.BLACK);
        assertTrue(newPawn instanceof Pawn);
        assertEquals(ChessColor.BLACK, newPawn.getColor());
        assertEquals("pawn", newPawn.getName());
    }

    @Test
    void validMovesTest() {

        Pawn pawn = new Pawn(ChessColor.BLACK);

        ChessPoint pawnPos = new ChessPoint(2, 2);

        ChessPieceMap map = new ChessPieceMap();

        map.put(pawnPos, pawn);

        assertEquals("[]", pawn.getValidMoves(map).toString());
    }
}
