package cp510.assignments.assignment9;

import java.util.List;

public class Bishop extends ChessPiece {

//    Encapsulates the characteristics of a bishop on a chess board. It has no properties other than those inherited from its superclass.It has one constructor and one method (as required by the abstract superclass).

    /**
     * @param color The color of this Bishop.
     */
    Bishop(ChessColor color) {
        super("", "", color);
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
//    public java.util.List<ChessPoint> getValidMoves ​(
//    ChessPieceMap chessMap) {}

    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
        // TODO Auto-generated method stub
        return null;
    };
//    Given the
//    state of
//    a chess
//    board calculate
//    all valid moves for this
//    Rook.If there
//    are no
//    valid moves
//    an empty
//    list will
//    be returned.
//
//    chessMap The
//    state of
//    the chess
//    board.

//    returns A
//    list of
//    all valid moves for this
//    Rook.
//
//    See also:
//    How to
//    Play Chess
//    page on
//    Chess.com
//    Calculating
//    Valid Moves

}
