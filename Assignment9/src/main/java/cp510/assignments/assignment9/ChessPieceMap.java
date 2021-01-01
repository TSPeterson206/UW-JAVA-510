package cp510.assignments.assignment9;

import java.util.HashMap;
import java.util.Objects;

/**
 * The ChessPieceMap class for the chess project. This class extends a
 * superclass of Hashmap. This is used as the basis for a chess board.
 * 
 * @author Toby Peterson.
 *
 */
public class ChessPieceMap extends HashMap<ChessPoint, ChessPiece> {

    /**
     * The default constructor for ChessPieceMap.
     */
    public ChessPieceMap() {
        new HashMap<ChessPoint, ChessPiece>(100, 0.75f);
    };

    /**
     * The get method for ChessPieceMap. This method is identical to get, but
     * throws an exception if the given point is not a valid square. Returns
     * null if the ChessPoint is not in the map.
     * 
     * @param point The key to the target ChessPiece.
     * @return The value associated with the key,or null if none found.
     * @throws ChessException Throws ChessException if the given ChessPoint is
     *                        not a valid square.
     */
    public ChessPiece get(ChessPoint point) throws ChessException {

        if (point.getCol() < 0 || point.getCol() > 7) {

            ChessException exc = new ChessException();
            Throwable e = exc.getCause();
            throw new ChessException(e);
        }
        if (point.getRow() < 0 || point.getRow() > 7) {
            throw new ChessException();
        }
        return super.get(point);
    }

    /**
     * The getKey method for ChessPieceMap. It gets the key associated with the
     * given value. Returns null if the given value cannot be found.
     * 
     * @param piece The chess piece to be found.
     * @return The key associated with the given value, or null if the value
     *         cannot be found.
     */
    public ChessPoint getKey(ChessPiece piece) {
        for (Entry<ChessPoint, ChessPiece> entry : super.entrySet()) {
            if (Objects.equals(piece, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * The put method for the ChessPieceMap class. It adds a
     * ChessPoint/ChessPiece entry to the map. Null values are not permitted.
     * This method is identical to put, but throws an exception if the given
     * point is not a valid square on a chess board, or the given value is null.
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
        if (piece == null) {
            throw new ChessException();
        }
        if (point.getCol() < 0 || point.getCol() > 7) {
            throw new ChessException(
                "Throwing an exception, out of column range.");
        }

        if (point.getRow() < 0 || point.getRow() > 7) {
            ChessException exc = new ChessException();
            Throwable e = exc.getCause();
            throw new ChessException("Chess exception thrown!", e);
        }
        super.put(point, piece);
        return piece;
    }

    /**
     * The newGame method for ChessPieceMap. Instantiates a ChessMap with all
     * pieces in the traditional start positions; a black rook will be in square
     * (0, 0).
     * 
     * @return A ChessMap with all pieces in the traditional start positions.
     */
    public static ChessPieceMap newGame() {
        ChessPieceMap newMap = new ChessPieceMap();
        newMap.put(new ChessPoint(1, 0), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 1), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 2), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 3), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 4), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 5), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 6), new Pawn(ChessColor.BLACK));
        newMap.put(new ChessPoint(1, 7), new Pawn(ChessColor.BLACK));

        newMap.put(new ChessPoint(0, 0), new Rook(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 1), new Knight(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 2), new Bishop(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 3), new King(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 4), new Queen(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 5), new Bishop(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 6), new Knight(ChessColor.BLACK));
        newMap.put(new ChessPoint(0, 7), new Rook(ChessColor.BLACK));

        newMap.put(new ChessPoint(6, 0), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 1), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 2), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 3), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 4), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 5), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 6), new Pawn(ChessColor.WHITE));
        newMap.put(new ChessPoint(6, 7), new Pawn(ChessColor.WHITE));

        newMap.put(new ChessPoint(7, 0), new Rook(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 1), new Knight(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 2), new Bishop(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 3), new King(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 4), new Queen(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 5), new Bishop(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 6), new Knight(ChessColor.WHITE));
        newMap.put(new ChessPoint(7, 7), new Rook(ChessColor.WHITE));
        return newMap;
    }

}
