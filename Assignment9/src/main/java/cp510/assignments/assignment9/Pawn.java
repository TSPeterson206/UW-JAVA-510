package cp510.assignments.assignment9;

import java.util.List;

public class Pawn extends ChessPiece {

//  Each of these classes represents a piece on a chess board.Each has a single constructor and a single method (required by the abstract superclass).

//  Constructor:
//  Knight​(ChessColor color){}

    /**
     * 
     * @param color The color of this chess piece.
     */
    Pawn(ChessColor color) {
        super("", "", color);

    }

    /**
     * 
     */
//  public java.util.List<ChessPoint> getValidMoves ​(
//  ChessPieceMap chessMap);
//  For the above classes this method will be a stub that returns an empty list ("new ArrayList<ChessPoint>()"). chessMap Not used returns An empty List<ChessPoint>.

    /**
     * 
     */
    @Override
    public List<ChessPoint> getValidMoves(ChessPieceMap chessMap) {
        // TODO Auto-generated method stub
        return null;
    }

}
