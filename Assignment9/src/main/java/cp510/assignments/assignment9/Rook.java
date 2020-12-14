package cp510.assignments.assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 * The Rook class for the chess project. This is a chess piece that extends the
 * superclass ChessPiece.
 * 
 * @author Toby Peterson.
 *
 */
public class Rook extends ChessPiece {

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
        List<ChessPoint> list = new ArrayList<ChessPoint>();

        ChessPoint currentKey = chessMap.getKey(this);

        int rowMod = currentKey.getRow();
        int colMod = currentKey.getCol();

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod + i, colMod))
                && (rowMod + i < 8)) {
                list.add(new ChessPoint(rowMod + i, colMod));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod + i, colMod))
                    && (chessMap.get(new ChessPoint(rowMod + i, colMod))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod + i, colMod));
                }
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod - i, colMod))
                && (rowMod - i > -1)) {
                list.add(new ChessPoint(rowMod - i, colMod));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod - i, colMod))
                    && (chessMap.get(new ChessPoint(rowMod - i, colMod))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod - i, colMod));
                }
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod, colMod + i))
                && (colMod + i < 8)) {
                list.add(new ChessPoint(rowMod, colMod + i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod, colMod + i))
                    && (chessMap.get(new ChessPoint(rowMod, colMod + i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod, colMod + i));
                }
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (!chessMap.containsKey(new ChessPoint(rowMod, colMod - i))
                && (colMod - i > -1)) {
                list.add(new ChessPoint(rowMod, colMod - i));
            } else {
                if (chessMap.containsKey(new ChessPoint(rowMod, colMod - i))
                    && (chessMap.get(new ChessPoint(rowMod, colMod - i))
                        .getColor() != this.getColor())) {
                    list.add(new ChessPoint(rowMod, colMod - i));
                }
                break;
            }
        }
        return list;
    }
}