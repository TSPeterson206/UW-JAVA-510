package cp510.assignments.assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 * The Bishop class for the chess project. This is a chess piece that extends
 * the superclass ChessPiece.
 * 
 * @author Toby Peterson.
 *
 */
public class Bishop extends ChessPiece {

    /**
     * The single-parameter constructor for Bishop.
     * 
     * @param color The color of this Bishop.
     */
    public Bishop(ChessColor color) {
        super("bishop", "", color);
    };

    /**
     * The getValidMoves method for Bishop. This method returns a list of all
     * valid moves for the encapsulated piece.
     * 
     * @param chessMap The state of the chess board.
     * @return A list of all valid moves for this Rook.
     */
    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
        List<ChessPoint> list = new ArrayList<ChessPoint>();

        ChessPoint currentKey = chessMap.getKey(this);

        int rowMod = currentKey.getRow();
        int colMod = currentKey.getCol();

        // Loop to test moving southeast
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod + i))
                && (rowMod + i < 8) && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod + i, colMod + i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod + i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod + i, colMod + i));
                }
                break;
            }
        }

        // loop to test moving northwest
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod - i))
                && (rowMod - i > -1) && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod - i, colMod - i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod - i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod - i, colMod - i));
                }
                break;
            }
        }

        // Loop to test moving Northeast
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod + i))
                && (rowMod - i > -1) && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod - i, colMod + i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod + i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod - i, colMod + i));
                }
                break;
            }
        }

        // Loop to test moving southwest
        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod - i))
                && (rowMod + i < 8) && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod + i, colMod - i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod - i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod + i, colMod - i));
                }
                break;
            }
        }
        return list;
    }
}
