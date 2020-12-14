package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ChessPieceMapTest {

    @Test
    void testExpectedExceptionBadPoint() {
        ChessPieceMap map = ChessPieceMap.newGame();
        ChessPoint point = new ChessPoint(3, 6);

        Assertions.assertThrows(ChessException.class, new Executable() {
            public void execute() throws Throwable {
                map.put(point, null);
            }
        });
    }

    @Test
    void testExpectedExceptionBadCol() {
        ChessPieceMap map = ChessPieceMap.newGame();
        Rook rookB = new Rook(ChessColor.BLACK);
        ChessPoint point = new ChessPoint(3, 9);

        Assertions.assertThrows(ChessException.class, new Executable() {
            public void execute() throws Throwable {
                map.put(point, rookB);
            }
        });
    }

    @Test
    void testExpectedExceptionNBadRow() {
        ChessPieceMap map = ChessPieceMap.newGame();
        Rook rookB = new Rook(ChessColor.BLACK);
        ChessPoint point = new ChessPoint(9, 3);
//        point.setRow(9);

        Assertions.assertThrows(ChessException.class, new Executable() {
            public void execute() throws Throwable {
                map.put(point, rookB);
            }
        });
    }

    @Test
    void testExpectedExceptionNBadColInGet() {
        ChessPieceMap map = ChessPieceMap.newGame();
        ChessPoint point = new ChessPoint(3, 9);

        Assertions.assertThrows(ChessException.class, new Executable() {
            public void execute() throws Throwable {
                map.get(point);
            }
        });
    }

    @Test
    void testExpectedExceptionNBadRowInGet() {
        ChessPieceMap map = ChessPieceMap.newGame();
        ChessPoint point = new ChessPoint(9, 3);

        Assertions.assertThrows(ChessException.class, new Executable() {
            public void execute() throws Throwable {
                map.get(point);
            }
        });
    }

    @Test
    void getTest() {
        ChessPieceMap map = new ChessPieceMap();

        Rook rookB = new Rook(ChessColor.BLACK);
        Bishop bishopB = new Bishop(ChessColor.BLACK);
        Knight knight = new Knight(ChessColor.WHITE);
        King king = new King(ChessColor.WHITE);
        Queen queen = new Queen(ChessColor.WHITE);
        Pawn pawn = new Pawn(ChessColor.BLACK);

        ChessPoint point = new ChessPoint(6, 3);
        ChessPoint point2 = new ChessPoint(5, 3);
        ChessPoint point3 = new ChessPoint(1, 3);
        ChessPoint point4 = new ChessPoint(2, 3);
        ChessPoint point5 = new ChessPoint(4, 3);
        ChessPoint point6 = new ChessPoint(3, 3);

        map.put(point, rookB);
        map.put(point2, bishopB);
        map.put(point3, knight);
        map.put(point4, king);
        map.put(point5, queen);
        map.put(point6, pawn);

        assertEquals("rook", map.get(point).getName());
        assertEquals("bishop", map.get(point2).getName());
        assertEquals("knight", map.get(point3).getName());
        assertEquals("king", map.get(point4).getName());
        assertEquals("queen", map.get(point5).getName());
        assertEquals("pawn", map.get(point6).getName());
        assertEquals(ChessColor.BLACK, map.get(point).getColor());
        assertEquals(ChessColor.BLACK, map.get(point2).getColor());
        assertEquals(ChessColor.WHITE, map.get(point3).getColor());
        assertEquals(ChessColor.WHITE, map.get(point4).getColor());
        assertEquals(ChessColor.WHITE, map.get(point5).getColor());
        assertEquals(ChessColor.BLACK, map.get(point6).getColor());
        assertTrue(map.get(point).getClass() == rookB.getClass());
        assertTrue(map.get(point2).getClass() == bishopB.getClass());
        assertTrue(map.get(point3).getClass() == knight.getClass());
        assertTrue(map.get(point4).getClass() == king.getClass());
        assertTrue(map.get(point5).getClass() == queen.getClass());
        assertTrue(map.get(point6).getClass() == pawn.getClass());
    }

    @Test
    void putTest() {
        ChessPieceMap map = new ChessPieceMap();

        Rook rookB = new Rook(ChessColor.BLACK);
        Bishop bishopB = new Bishop(ChessColor.BLACK);
        Knight knight = new Knight(ChessColor.WHITE);
        King king = new King(ChessColor.WHITE);
        Queen queen = new Queen(ChessColor.WHITE);
        Pawn pawn = new Pawn(ChessColor.BLACK);

        ChessPoint point = new ChessPoint(6, 3);
        ChessPoint point2 = new ChessPoint(5, 3);
        ChessPoint point3 = new ChessPoint(1, 3);
        ChessPoint point4 = new ChessPoint(2, 3);
        ChessPoint point5 = new ChessPoint(4, 3);
        ChessPoint point6 = new ChessPoint(3, 3);

        map.put(point, rookB);
        map.put(point2, bishopB);
        map.put(point3, knight);
        map.put(point4, king);
        map.put(point5, queen);
        map.put(point6, pawn);

        assertEquals("rook", map.get(point).getName());
        assertEquals("bishop", map.get(point2).getName());
        assertEquals("knight", map.get(point3).getName());
        assertEquals("king", map.get(point4).getName());
        assertEquals("queen", map.get(point5).getName());
        assertEquals("pawn", map.get(point6).getName());
        assertEquals(ChessColor.BLACK, map.get(point).getColor());
        assertEquals(ChessColor.BLACK, map.get(point2).getColor());
        assertEquals(ChessColor.WHITE, map.get(point3).getColor());
        assertEquals(ChessColor.WHITE, map.get(point4).getColor());
        assertEquals(ChessColor.WHITE, map.get(point5).getColor());
        assertEquals(ChessColor.BLACK, map.get(point6).getColor());
        assertTrue(map.get(point).getClass() == rookB.getClass());
        assertTrue(map.get(point2).getClass() == bishopB.getClass());
        assertTrue(map.get(point3).getClass() == knight.getClass());
        assertTrue(map.get(point4).getClass() == king.getClass());
        assertTrue(map.get(point5).getClass() == queen.getClass());
        assertTrue(map.get(point6).getClass() == pawn.getClass());
    }

    @Test
    void getKeyTest() {
        ChessPieceMap map = new ChessPieceMap();
        ChessPoint point = new ChessPoint(6, 3);
        Rook rookB = new Rook(ChessColor.BLACK);
        map.put(point, rookB);
        assertEquals(point, map.getKey(rookB));
        assertEquals(null, map.getKey(null));
    }

    @Test
    void newGameTest() {
        ChessPieceMap map = ChessPieceMap.newGame();
        assertEquals(32, map.size());
    }
}
