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
        ChessPieceMap map = ChessPieceMap.newGame();
        Rook rookB = new Rook(ChessColor.BLACK);
        Bishop bishopB = new Bishop(ChessColor.BLACK);

        System.out.println("*********" + bishopB.getName());

        ChessPoint point = new ChessPoint(6, 3);

        ChessPoint point2 = new ChessPoint(5, 3);
        map.put(point2, bishopB);

        assertEquals("bishop", map.get(point2).getName());

        map.put(point, rookB);
        assertEquals("rook", map.get(point).getName());
        assertEquals(ChessColor.BLACK, map.get(point).getColor());
        assertTrue(map.get(point).getClass() == rookB.getClass());

    }

}
