package cp510.assignments.assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author toby
 *
 */
public class Bishop extends ChessPiece {

//    Encapsulates the characteristics of a bishop on a chess board. It has no properties other than those inherited from its superclass.It has one constructor and one method (as required by the abstract superclass).

    /**
     * @param color The color of this Bishop.
     */
    Bishop(ChessColor color) {
        super("bishop", "", color);
    };

//    color
//    The color of this bishop.
//
//    Method:

    /**
     * The getValidMoves method for Bishop.
     * 
     * @param chessMap The state of the chess board.
     * @return A list of all valid moves for this Rook.
     */
    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
//        System.out.println("hitting getvalidmovesrook:" + chessMap.entrySet());
        List<ChessPoint> list = new ArrayList<ChessPoint>();

        ChessPoint currentKey = chessMap.getKey(this);

        int rowMod = currentKey.getRow();
        int colMod = currentKey.getCol();

        // Loop to test moving southeast
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod + i))
                && (rowMod + i < 8) && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod + i, colMod + i));

//                if (rowMod + i > 7) {
//                    System.out.println("hitting up done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting up else");

                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod + i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod + i, colMod + i));
                }
                ;
                break;
            }

        }

        // loop to test moving northwest
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod - i))
                && (rowMod - i > -1) && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod - i, colMod - i));

//                if (rowMod - i < 0) {
//                    System.out.println("hitting down done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting down else");

                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod - i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod - i, colMod - i));
                }
                ;
                break;
            }
        }

        // Loop to test moving Northeast
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod + i))
                && (rowMod - i > -1) && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod - i, colMod + i));

//                if (colMod + i > 7) {
//                    System.out.println("hitting right done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting right else");

                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod + i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod - i, colMod + i));
                }
                ;
                break;
            }
        }

        // Loop to test moving southwest
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod - i))
                && (rowMod + i < 8) && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod + i, colMod - i));

//                if (colMod - i < 0) {
//                    System.out.println("hitting left done");
//                    continue;
//                }
//                ;
            } else {
//                System.out.println("hitting left else");

                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod - i))
                        .getColor() != this.getColor())

                ) {
                    list.add(new ChessPoint(rowMod + i, colMod - i));
                }
                ;
                break;
            }
        }
//        System.out.println("list:" + list);
        return list;
    }
}
