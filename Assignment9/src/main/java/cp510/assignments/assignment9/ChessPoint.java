package cp510.assignments.assignment9;

/**
 * The ChessPoint class for the chess project. This is the row and column
 * coordinates used to place,remove, check on the position of ChessPiece on the
 * ChessPieceMap (a hashmap).
 * 
 * @author Toby Peterson.
 *
 */
public class ChessPoint {

    /**
     * The row of a square on the board
     */
    private int row;

    /**
     * The column of a square on the board
     */
    private int col;

    /**
     * The default constructor for ChessPoint. It sets the row and col
     * properties to (0, 0).
     */
    public ChessPoint() {
        setCol(0);
        setRow(0);
    }

    /**
     * The two parameter constructor for ChessPoint. It sets the row and column
     * to the given values.
     * 
     * @param row The given row.
     * @param col The given column.
     */
    public ChessPoint(int row, int col) {
        setRow(row);
        setCol(col);
    }

    /**
     * The copy constructor; copies the properties of the given ChessPoint to
     * this ChessPoint.
     * 
     * @param toCopy The given ChessPoint.
     */
    public ChessPoint(ChessPoint toCopy) {
        setPoint(toCopy.getRow(), toCopy.getCol());
    }

    /**
     * 
     * The add method for ChessPoint. It adds the given values to the row and
     * column of this object.If the operation would cause either property to be
     * less than 0 or greater than 7 the operation is not performed and false is
     * returned.
     * 
     * @param row The value to add to row.
     * @param col The value to add to col.
     * @return True if the result of the operation is the location of a square
     *         on a chess board.
     */
    public boolean add(int row, int col) {

        int rowTotal = getRow() + row;
        int colTotal = getCol() + col;

        if (rowTotal > 7 || rowTotal < 0) {
            return false;
        }
        ;
        if (colTotal > 7 || colTotal < 0) {
            return false;
        }
        ;
        setRow(rowTotal);
        setCol(colTotal);
        return true;
    }

    /**
     * The hashCode method for ChessPoint. It calculates a hash code for this
     * ChessPoint. The algorithm produces a perfect hash in the range (0, 0) to
     * (7, 7), inclusive. There should never be a collision between two points
     * on a chess board. The algorithm is: 8 x row + col.
     * 
     * @return The calculated hashcode.
     */
    public int hashCode() {
        return 8 * getRow() + getCol();
    }

    /**
     * The equals method for ChessPoint. It returns true if this ChessPoint is
     * equal to the given object. The objects are equal if the given object is
     * non-null, is an instance of ChessPoint and has the same row and column
     * coordinates as this ChessPiece.
     * 
     * @param obj The given object.
     * @return True if the given object is equal to this ChessPoint, false if
     *         not.
     */
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null)
            result = false;
        else if (this.getClass() != obj.getClass())
            result = false;
        else {
            ChessPoint that = (ChessPoint) obj;
            if (this.getCol() != that.getCol())
                ;
            else if (this.getRow() != that.getRow())
                ;
            else {
                result = true;
            }
        }
        return result;
    }

    /**
     * The getCol method for ChessPoint.
     * 
     * @return The value of the column property.
     */
    public int getCol() {
        return col;
    }

    /**
     * The setCol method for ChessPoint. The setter for the column property.
     * 
     * @param col The new value of the column property.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Getter for the row property.
     * 
     * @return The value of the row property.
     */
    public int getRow() {
        return row;
    }

    /**
     * The setter for the row property.
     * 
     * @param row The new value of the row property.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * The setPoint method for ChessPoint. It is a convenience method to set the
     * row and column properties at the same time.
     * 
     * @param row The new value of the row property.
     * @param col The new value of the column property.
     */
    public void setPoint(int row, int col) {
        setCol(col);
        setRow(row);
    }

    /**
     * The toString method for ChessPoint
     * 
     * @return A readable string representing the properties of this ChessPoint.
     */
    public String toString() {
        StringBuilder bldr = new StringBuilder();
        bldr.append("row = ").append(getRow()).append(", column = ")
            .append(getCol());
        return bldr.toString();
    }
}
