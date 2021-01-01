package cp510.assignments.assignment9;

import java.awt.Image;
import java.util.List;

/**
 * The ChessPiece class for the chess project. This abstract class is the root
 * class of all chess pieces.
 * 
 * @author Toby Peterson.
 *
 */
public abstract class ChessPiece {

    /**
     * The name of this chess piece, e.g. "bishop".
     */
    private String name;
    /**
     * The image to draw on the chess board. For this assignment this value will
     * always be null
     */
    private Image image;

    /**
     * The color of this chess piece
     */
    private ChessColor color;
    /**
     * True if this chess piece has not been captured
     */
    private boolean isAlive;

    /**
     * The 3-parameter constructor for Chess Piece. When invoking this
     * constructor, the imagePath is the empty string, the color will be one of
     * ChessColor.BLACK or ChessColor.WHITE, and the name will be the name of
     * the chess piece.
     * 
     * @param name      The name of this chess piece.
     * @param imagePath The path to the file containing the image for this chess
     *                  piece. For this assignment, it returns an empty string.
     * @param color     The color of this chess piece.
     */
    public ChessPiece(String name, String imagePath, ChessColor color) {
        this.name = name;
//        this.image = "";
        this.isAlive = true;
        this.color = color;
    }

    /**
     * The abstract method getValidMoves. It returns a list of all valid moves
     * for this chess piece given the state of the chess board. Note: all
     * ChessPiece subclasses except Bishop and Rook should return an empty list.
     * 
     * 
     * @param chessMap The current state of the chess board.
     * @return A list of all valid moves for this chess piece.
     */
    public abstract List<ChessPoint> getValidMoves(ChessPieceMap chessMap);

    /**
     * The getName getter for the name property.
     * 
     * @return The value of the name property.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The getImage getter for the image property. Note:for this assignment this
     * method should return null.
     * 
     * @return The value of the image property.
     */
    public Image getImage() {

        return null;
    }

    /**
     * The getter for this chess piece's color.
     * 
     * @return ChessColor The color of the chess piece.
     */
    public ChessColor getColor() {
        return this.color;
    }

    /**
     * The getter for the isAlive property.
     * 
     * @return boolean Returns true if this piece has not been captured.
     * 
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * The setter for the isAlive property.
     * 
     * @param alive The boolean that determines if this piece is alive or not.
     */
    public void setAlive(boolean alive) {
        {
            this.isAlive = alive;
        }
    }
}
