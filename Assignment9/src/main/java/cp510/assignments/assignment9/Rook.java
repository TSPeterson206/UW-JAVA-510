package cp510.assignments.assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author toby
 *
 */
public class Rook extends ChessPiece {

//    Encapsulates the characteristics of a rook on a chess board. It has no properties other than those inherited from its superclass.It has one constructor and one method (as required by the abstract superclass).

//    Constructor:

    /**
     * The default constructor for the Rook class.
     * 
     * @param color The color of this rook.
     */
    public Rook(ChessColor color) {
        super("rook", "", color);
    }

    /**
     * The getValidMoves method for Rook.
     * 
     * @param chessMap The state of the chess board.
     * @return A list of all valid moves for thisRook.
     */
    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
//        System.out.println("hitting getvalidmovesrook:" + chessMap.entrySet());
        List<ChessPoint> list = new ArrayList<ChessPoint>();

        ChessPoint currentKey = chessMap.getKey(this);

        int rowMod = currentKey.getRow();
        int colMod = currentKey.getCol();

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod))
                && (rowMod + i < 8)) {
                list.add(new ChessPoint(rowMod + i, colMod));

//                if (rowMod + i > 7) {
//                    System.out.println("hitting up done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting up else");

                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod + i, colMod));
                }
                ;
                break;
            }

        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod))
                && (rowMod - i > -1)) {
                list.add(new ChessPoint(rowMod - i, colMod));

//                if (rowMod - i < 0) {
//                    System.out.println("hitting down done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting down else");

                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod - i, colMod));
                }
                ;
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod, colMod + i))
                && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod, colMod + i));

//                if (colMod + i > 7) {
//                    System.out.println("hitting right done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting right else");

                if (chessMap.containsKey(new ChessPoint(rowMod, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod, colMod + i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod, colMod + i));
                }
                ;
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod, colMod - i))
                && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod, colMod - i));

//                if (colMod - i < 0) {
//                    System.out.println("hitting left done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting left else");
                if (chessMap.containsKey(new ChessPoint(rowMod, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod, colMod - i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod, colMod - i));
                }
                ;
                break;
            }
        }
//        System.out.println("list:" + list);
        return list;
    }
}