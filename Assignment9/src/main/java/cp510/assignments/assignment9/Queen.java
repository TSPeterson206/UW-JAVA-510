package cp510.assignments.assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 * The Queen class for the chess project. This is a chess piece that extends the
 * superclass ChessPiece.
 * 
 * @author Toby Peterson.
 *
 */
public class Queen extends ChessPiece {

    /**
     * The single-parameter constructor for Queen.
     * 
     * @param color The color of this chess piece.
     */
    public Queen(ChessColor color) {
        super("queen", "", color);
    }

    /**
     * The getValidMoves method for the chess piece. For this project, this
     * particular piece (all except rook and bishop) will return an empty list.
     *
     * 
     * @param chessMap The state of the chess board.
     * @return An empty list.
     */
    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
        return new ArrayList<ChessPoint>();
    }

}
