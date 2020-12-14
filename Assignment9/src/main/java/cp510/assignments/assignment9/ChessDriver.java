package cp510.assignments.assignment9;

import java.util.List;

public class ChessDriver {

    public static void main(String[] args) {
        newGame();
        validMovesRook();
        validMovesBishop();
        driverConfig();
    }

    private static void newGame() {
        ChessPieceMap map = ChessPieceMap.newGame();
        for (int row = 0; row < 8; ++row)
            for (int col = 0; col < 8; ++col) {
                ChessPoint point = new ChessPoint(row, col);
                ChessPiece piece = map.get(point);
                StringBuilder bldr = new StringBuilder();
                bldr.append(point).append(' ');
                if (piece == null)
                    bldr.append("null");
                else {
                    bldr.append(piece.getName()).append(" ")
                        .append(piece.getColor());
                }
                System.out.println(bldr);
            }
    }

    private static void validMovesRook() {
        Rook rookB = new Rook(ChessColor.BLACK);
        Rook rookW = new Rook(ChessColor.WHITE);
        Bishop bishopW = new Bishop(ChessColor.WHITE);

        /*
         * Rook 0 1 2 3 4 5 6 7 0 o o o R o o B o 1 x x x o x x x x 2 x x x o x
         * x x x 3 x x x o x x x x 4 x x x r x x x x 5 x x x x x x x x 6 x x x x
         * x x x x 7 x x x x x x x x
         */
        ChessPoint rookWPos = new ChessPoint(0, 3);
        ChessPoint rookBPos = new ChessPoint(4, 3);
        ChessPoint bishopWPos = new ChessPoint(0, 6);

        ChessPieceMap map = new ChessPieceMap();
        map.put(rookWPos, rookW);
        map.put(rookBPos, rookB);
        map.put(bishopWPos, bishopW);

        List<ChessPoint> list = rookW.getValidMoves(map);
        System.out.println("White Rook");
        printList(list);
    }

    private static void validMovesBishop() {
        Rook rookB = new Rook(ChessColor.BLACK);
        Rook rookW = new Rook(ChessColor.WHITE);
        Bishop bishopW = new Bishop(ChessColor.WHITE);

        /*
         * Rook 0 1 2 3 4 5 6 7 0 x x o x x x R x 1 x x x o x o x x 2 x x x x B
         * x x x 3 x x x o x o x x 4 x x o x x x o x 5 x r x x x x x o 6 x x x x
         * x x x x 7 x x x x x x x x
         */
        ChessPoint rookWPos = new ChessPoint(0, 6);
        ChessPoint rookBPos = new ChessPoint(5, 1);
        ChessPoint bishopWPos = new ChessPoint(2, 4);

        ChessPieceMap map = new ChessPieceMap();
        map.put(rookWPos, rookW);
        map.put(rookBPos, rookB);
        map.put(bishopWPos, bishopW);

        List<ChessPoint> list = bishopW.getValidMoves(map);
        System.out.println("White Bishop");
        printList(list);
    }

    private static void driverConfig() {
        Rook rookB = new Rook(ChessColor.BLACK);
        Bishop bishopB = new Bishop(ChessColor.BLACK);
        Bishop bishopW = new Bishop(ChessColor.WHITE);

        /*
         * Rook 0 1 2 3 4 5 6 7 0 x o x x x x x x 1 x o x x x x x x 2 o r o o o
         * B x x 3 x o x x o x x x 4 x o x o x x x x 5 o o o x x x x x 6 x b x x
         * x x x x 7 o x o x x x x x
         */
        ChessPoint rookBPos = new ChessPoint(2, 1);
        ChessPoint bishopBPos = new ChessPoint(6, 1);
        ChessPoint bishopWPos = new ChessPoint(2, 5);

        ChessPieceMap map = new ChessPieceMap();
        map.put(rookBPos, rookB);
        map.put(bishopBPos, bishopB);
        map.put(bishopWPos, bishopW);

        List<ChessPoint> list = rookB.getValidMoves(map);
        System.out.println("DriverConfig: Black Rook");
        printList(list);

        list = bishopB.getValidMoves(map);
        System.out.println("DriverConfig: Black Bishop");
        printList(list);
    }

    private static void printList(List<ChessPoint> list) {
        list.sort(
            (p1, p2) -> p1.getRow() != p2.getRow() ? p1.getRow() - p2.getRow()
                : p1.getCol() - p2.getCol());
        list.forEach(System.out::println);
    }
}