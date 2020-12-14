package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RookTest {

    @Test
    void constructorTest() {
        Rook newRook = new Rook(ChessColor.BLACK);
    }

    @Test
    void validMovesTest() {

        Rook rookB = new Rook(ChessColor.BLACK);
        Rook rookW = new Rook(ChessColor.WHITE);
        Bishop bishopW = new Bishop(ChessColor.WHITE);

        ChessPoint rookWPos = new ChessPoint(2, 3);
        ChessPoint rookBPos = new ChessPoint(4, 3);
        ChessPoint rookBPos2 = new ChessPoint(0, 3);
        ChessPoint rookBPos3 = new ChessPoint(2, 0);
        ChessPoint rookBPos4 = new ChessPoint(2, 5);
        ChessPoint bishopWPos = new ChessPoint(0, 6);

        ChessPieceMap map = new ChessPieceMap();

        map.put(rookWPos, rookW);
        map.put(rookBPos2, rookB);
        map.put(rookBPos3, rookB);
        map.put(rookBPos4, rookB);
        map.put(rookBPos, rookB);
        map.put(bishopWPos, bishopW);

        assertEquals(
            "[row = 3, column = 3, row = 4, column = 3, row = 1, column = 3,"
                + " row = 0, column = 3, row = 2, column = 4, row = 2, column = 5,"
                + " row = 2, column = 2, row = 2, column = 1, row = 2, column = 0]",
            rookW.getValidMoves(map).toString());
    }

}
