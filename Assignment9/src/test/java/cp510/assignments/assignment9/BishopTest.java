package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BishopTest {

    @Test
    void constructorTest() {
        Bishop newBishop = new Bishop(ChessColor.BLACK);
        assertTrue(newBishop instanceof Bishop);
    }

    @Test
    void validMovesTest() {

        Rook rookB = new Rook(ChessColor.BLACK);
        Rook rookW = new Rook(ChessColor.BLACK);
        Bishop bishopW = new Bishop(ChessColor.WHITE);

        ChessPoint bishopWPos = new ChessPoint(4, 4);

        ChessPoint rookWPos = new ChessPoint(2, 2);
        ChessPoint rookBPos = new ChessPoint(6, 6);
        ChessPoint rookBPos2 = new ChessPoint(2, 6);
        ChessPoint rookBPos3 = new ChessPoint(6, 2);
        ChessPoint rookBPos4 = new ChessPoint(2, 5);

        ChessPieceMap map = new ChessPieceMap();

        map.put(rookWPos, rookW);
        map.put(rookBPos2, rookB);
        map.put(rookBPos3, rookB);
        map.put(rookBPos4, rookB);
        map.put(rookBPos, rookB);
        map.put(bishopWPos, bishopW);

        assertEquals(
            "[row = 5, column = 5, row = 6, column = 6, row = 3, column = 3,"
                + " row = 2, column = 2, row = 3, column = 5, row = 2, column = 6,"
                + " row = 5, column = 3, row = 6, column = 2]",
            bishopW.getValidMoves(map).toString());
    }

}
