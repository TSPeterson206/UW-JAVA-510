package cp510.assignments.assignment9;

import java.awt.Image;
import java.util.List;

public abstract class ChessPiece {

//    Root class of all chess pieces, this class will have the following properties, constructors and methods.

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
    boolean isAlive;

    /**
     * @param name
     * @param imagePath
     * @param color
     */
    public ChessPiece(String name, String imagePath, ChessColor color) {
        System.out.println("hitting chesspiece");
        this.name = name;
//        this.imagePath="";
        this.color = color;
    }

//    name
//    The name of this chess piece.
//
//    imagePath
//    The path to the file containing the image for this chess piece.
//    Note: for this assignment please pass the empty string ("").
//
//    color
//    The color of this chess piece.

//    Discussion:
//    When invoking this constructor, the imagePath should be the empty string, the color will be one of ChessColor.BLACK or ChessColor.WHITE, and the name will be the name of the chess piece:
//
//    Class
//    Name
//    Rook
//    "rook"
//    Bishop
//    "bishop"
//    Knight
//    "knight"
//    Queen
//    "queen"
//    King
//    "king"
//    Pawn
//    "pawn"

//    Methods:
    /**
     * 
     * @param chessMap The current state of the chess board.
     * @return A list of all valid moves for this chess piece.
     */
    public abstract List<ChessPoint> getValidMoves(ChessPieceMap chessMap);
//    Returns a list of all valid moves for this chess piece given the state of the chess board.Note: all ChessPiece subclasses except Bishop and Rook should return an empty list (return new ArrayList<ChessPoint>()).    

    /**
     * The getName getter for the name property.
     * 
     * @return The value of the name property.
     */
    public int getName() {
        return 0;
    }

    /**
     * The getImage getter for the image property.
     * 
     * @return The value of the image property.
     */
    public Image getImage() {

        return null;
    }

//    returns The
//    value of
//    the image property.Note:for this assignment this
//    method should return null.

    /**
     * The getter for this chess piece's color.
     * 
     * @return ChessColor The color of the chess piece.
     */
    public ChessColor getColor() {
        return null;
    }

//        returns This chess piece'scolor.

    /**
     * The getter for the isAlive property.
     * 
     * @return boolean Returns true if this piece has not been captured.
     * 
     */
    public boolean isAlive() {
        return true;
    }

    /**
     * The setter for the isAlive property.
     * 
     * @param alive The boolean
     */
    public void setAlive(boolean alive) {
        {

        }
    }
}
