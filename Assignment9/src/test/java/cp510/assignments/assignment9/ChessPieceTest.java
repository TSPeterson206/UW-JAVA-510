package cp510.assignments.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Graphics2D;
import java.util.List;

import org.junit.jupiter.api.Test;

class ChessPieceTest {

    @Test
    void isaliveSetAndCheck() {
        NestedTestClass newPiece = new NestedTestClass("rook", "",
            ChessColor.BLACK);

        assertEquals(true, newPiece.isAlive());
        newPiece.setAlive(false);
        assertEquals(false, newPiece.isAlive());
    }

    @Test
    void getNameTest() {
        NestedTestClass newPiece = new NestedTestClass("rook", "",
            ChessColor.BLACK);

        assertEquals("rook", newPiece.getName());
    }

    @Test
    void getImageTest() {
        NestedTestClass newPiece = new NestedTestClass("rook", "",
            ChessColor.BLACK);

        assertEquals(null, newPiece.getImage());
    }

    @Test
    void getColorTest() {
        NestedTestClass newPiece = new NestedTestClass("rook", "",
            ChessColor.BLACK);

        assertEquals(ChessColor.BLACK, newPiece.getColor());
    }

    private static class NestedTestClass extends ChessPiece {
        public NestedTestClass(String name, String imagePath,
            ChessColor color) {
            super(name, "", color);
        }

        public static void main(String[] args) {
            NestedTestClass newOne = new NestedTestClass("rook", "",
                ChessColor.BLACK);
            System.out.println(newOne.toString());
        }

        public void draw(Graphics2D gtx) {
        }

        @Override
        public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
            // TODO Auto-generated method stub
            return null;
        }

    }
}
