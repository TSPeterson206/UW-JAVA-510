package cp510.assignments.assignment9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ChessExceptionTest {

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

}
