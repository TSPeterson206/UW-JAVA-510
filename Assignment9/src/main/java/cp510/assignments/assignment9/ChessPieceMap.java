package cp510.assignments.assignment9;

import java.util.HashMap;

/**
 * The ChessPieceMap class for the chess project.
 * 
 * @author Toby Peterson.
 *
 */
public class ChessPieceMap extends HashMap<ChessPoint, ChessPiece> {

    /**
     * The default constructor for ChessPieceMap.
     */
    public ChessPieceMap() {
    };
//        Constructor. Creates a <ChessPoint,ChessPiece> map with an initial size of 100, and a load factor of .75.

//        Methods:

    /**
     * The get method for ChessPieceMap. This method is identical to
     * Map<ChessPoint,ChessPiece>.get, but throws an exception if the given
     * point is not a valid square. Returns null if the ChessPoint is not in the
     * map.
     * 
     * @param point The key to the target ChessPiece.
     * @return The value associated with the key,or null if none found.
     * @throws ChessException Throws ChessException if the given ChessPoint is
     *                        not a valid square.
     */
    public ChessPiece get(ChessPoint point) throws ChessException {
        return null;
    }

    /**
     * The getKey method for ChessPieceMap. It gets the key associated with the
     * given value.Returns null if the given value cannot be found.
     * 
     * @param piece The chess piece to be found.
     * @return The key associated with the given value, or null if the value
     *         cannot be found.
     */
    public ChessPoint getKey(ChessPiece piece) {
        return null;
    }

//    Discussion:
//    There is
//    no corresponding
//    method in
//    the superclass.
//    To implement this method,
//    get the
//    set of
//    keys associated with this
//    map.Use each
//    key to
//    interrogate the
//    map until
//    the target
//    value is found,
//    or until
//    the set
//    of keys
//    is exhausted.

    /**
     * 
     * @param point The key for the new entry.
     * @param piece The value for the new entry.
     * @return The value previously associated with the key, or null if none.
     * @throws ChessException Throws ChessException if the given key is not a
     *                        valid square on a chess board, or if the given
     *                        value is null.
     */
    public ChessPiece put(ChessPoint point, ChessPiece piece)
        throws ChessException {
        return null;
    }

//    Adds
//    a ChessPoint/
//    ChessPiece entry
//    to the
//    map.Null values
//    are not
//    permitted.This method
//    is identical
//    to Map<ChessPoint,ChessPiece>.put,but throws
//    an exception if
//    the given
//    point is
//    not a
//    valid square
//    on a
//    chess board, or
//    the given
//    value is null.

    /**
     * The newGame method for ChessPieceMap. Instantiates a ChessMap with all
     * pieces in the traditional start positions; a black rook will be in square
     * (0, 0).
     * 
     * @return A ChessMap with all pieces in the traditional start positions.
     */
    public static ChessPieceMap newGame() {
        return null;
    }

}
