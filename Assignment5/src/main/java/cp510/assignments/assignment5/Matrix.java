package cp510.assignments.assignment5;

/**
 * The Matrix class for UW java 510 assignment 5 (Matrices).
 * 
 * This call encapsulates simple matrix operations. It has methods for adding,
 * subtracting, negating and multiplying two matrices. Beyond that it has the
 * ability to check two different matrices for equality, as well as grabbing
 * data from a matrix such as individual elements and row/column quantities.
 * 
 * @author Toby Peterson.
 */
public class Matrix {

    /**
     * The double containing the two-dimensional array for the current matrix.
     */
    private double[][] data;
    /**
     * A string used to make a string builder in order to output a human
     * readable string.
     */
    private String holder;
    /**
     * A two-dimensional array of doubles that is identical in length to
     * internal data in order to use the accumulator pattern.
     */
    private double[][] acc;
    /**
     * The amount of rows of the two-dimensional array passed to constructor.
     */
    private int rows;
    /**
     * The amount of columns of the two-dimensional array passed to constructor.
     */
    private int cols;

    /**
     * Matrix constructor. Creates a matrix object from the given input. Throw
     * MatrixException if the array is not rectangular (i.e. if rows have
     * different lengths).
     * 
     * @param dataIn A two dimensional array to be used as the base matrix for a
     *               new Matrix instance.
     * @throws MatrixException.
     */
    public Matrix(double[][] dataIn) throws MatrixException {
        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        final int lengthOfRow = dataIn[0].length;

        for (int i = 0; i < dataIn.length; i++) {
            if (dataIn[i].length != lengthOfRow) {

                MatrixException exc = new MatrixException();
                Throwable e = exc.getCause();
                throw new MatrixException("Matrix exception thrown!", e);
            }
            ;
            bldr.append("|");
            for (int j = 0; j < dataIn[i].length; j++) {
                bldr.append(String.format("%7.3f", dataIn[i][j]));
            }
            bldr.append("|");
            bldr.append(newl);
        }
        ;
        data = dataIn;
        rows = getNumRows();
        cols = getNumColumns();
        holder = bldr.toString();
        acc = new double[rows][cols];
    };

    /**
     * The Add method for the Matrix class.
     * 
     * Adds a given matrix to this matrix. The result is a new matrix object.
     * Throws MatrixException if this matrix and the given matrix have different
     * dimensions.
     * 
     * @param toAdd The given matrix to add.
     * @return A new Matrix that is the sum of the data variable and the toSum
     *         argument.
     * @throws MatrixException.
     */
    public Matrix add(Matrix toAdd) throws MatrixException {
        Matrix internal = new Matrix(data);

        if (toAdd.getNumRows() != internal.getNumRows()
            || toAdd.getNumColumns() != internal.getNumColumns()) {

            MatrixException exc = new MatrixException();
            Throwable e = exc.getCause();
            throw new MatrixException(e);
        }

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        double[][] added = toAdd.data;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                acc[i][j] = data[i][j] + added[i][j];
                bldr.append(String.format("%7.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        return new Matrix(acc);
    };

    /**
     * The Subtract method for the Matrix class.
     * 
     * Subtracts a given matrix from this matrix. The result is a new matrix
     * object. Throws MatrixException if this matrix and the given matrix have
     * different dimensions.
     * 
     * @param toSub The given matrix to subtract.
     * @return A new Matrix that is the difference of the data variable and the
     *         toSub argument.
     * @throws MatrixException.
     */
    public Matrix subtract(Matrix toSub) throws MatrixException {

        Matrix internal = new Matrix(data);

        if (toSub.getNumRows() != internal.getNumRows()
            || toSub.getNumColumns() != internal.getNumColumns()) {
            throw new MatrixException();
        }

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        double[][] added = toSub.data;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                acc[i][j] = data[i][j] - added[i][j];
                bldr.append(String.format("%7.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        return new Matrix(acc);
    };

    /**
     * The Multiply method for the Matrix class.
     * 
     * Multiplies a given matrix by this matrix. The result is a new matrix
     * object. Throws MatrixException if this matrix and the given matrix have
     * different dimensions.
     * 
     * @param toMul The given matrix to subtract.
     * @return A new Matrix that is the product of the data variable and the
     *         toMul argument.
     * @throws MatrixException.
     */
    public Matrix multiply(Matrix toMul) throws MatrixException {

        Matrix newMatrix = new Matrix(data);

        if (toMul.getNumRows() != newMatrix.getNumColumns()) {
            throw new MatrixException("Cant multiply these dimension");
        }

        final int r1 = newMatrix.getNumRows(), c1 = newMatrix.getNumColumns();
        final int r2 = toMul.getNumRows(), c2 = toMul.getNumColumns();

        final double[][] current = newMatrix.getData();
        final double[][] multi = toMul.data;
        double[][] product = new double[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += current[i][k] * multi[k][j];
                }
            }
        }
        return new Matrix(product);
    };

    /**
     * The Multiply (scalar) method for the Matrix class.
     * 
     * Multiplies a given matrix by the provided scalar value. The result is a
     * new matrix object. Throws MatrixException if this matrix and the given
     * matrix have different dimensions.
     * 
     * @param scalar The given scalar value.
     * @return A new Matrix that is the product of the data variable and the
     *         scalar argument.
     */
    public Matrix multiply(double scalar) {
        Matrix newMatrix = new Matrix(data);

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        double[][] newMatrixData = newMatrix.getData();

        for (int i = 0; i < newMatrixData.length; i++) {
            for (int j = 0; j < newMatrixData[i].length; j++) {
                newMatrixData[i][j] = newMatrixData[i][j] * scalar;
                bldr.append(String.format("%7.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        return new Matrix(newMatrixData);
    };

    /**
     * The Negate method for the Matrix class.
     * 
     * Negates a given matrix. The result is a new matrix object.
     * 
     * @return A new Matrix that is the difference of the data variable and the
     *         toSub argument.
     */
    public Matrix negate() {

        Matrix newMatrix = new Matrix(data);

        int r1 = newMatrix.getNumRows(), c1 = newMatrix.getNumColumns();

        double[][] current = newMatrix.getData();
        double[][] result = new double[r1][c1];

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[i].length; j++) {
                result[i][j] = -1 * current[i][j];
                bldr.append(String.format("%7.3f", result[i][j]));
            }
            bldr.append(newl);
        }
        holder = bldr.toString();
        return new Matrix(result);
    };

    /**
     * The getElement method.
     * 
     * @param row The row count.
     * @param col The column count.
     * @return The value of the element at the specified row and column.
     * @throws IndexOutOfBoundsException.
     */
    public double getElement(int row, int col)
        throws IndexOutOfBoundsException {
        try {
            return data[row][col];
        } catch (IndexOutOfBoundsException exc) {
            throw new IndexOutOfBoundsException(
                "Element isn't there" + exc.getCause());
        }
    };

    /**
     * The getData method.
     * 
     * @return A copy of the value stored in the data variable.
     */
    public double[][] getData() {
        double[][] copy = this.data;
        return copy;
    };

    /**
     * The getRow method.
     * 
     * @param row The provided row value to return.
     * @return The row of the matrix at the provided row value.
     * @throws IndexOutOfBoundsException.
     */
    public double[] getRow(int row) throws IndexOutOfBoundsException {
        try {
            return data[row];
        } catch (IndexOutOfBoundsException exc) {
            throw exc;
        }
    };

    /**
     * The getCol method.
     * 
     * @param col The provided row value to return.
     * @return The column of the matrix at the provided column value.
     * @throws IndexOutOfBoundsException
     */
    public double[] getCol(int col) throws IndexOutOfBoundsException {
        try {
            return data[col];
        } catch (IndexOutOfBoundsException exc) {
            throw exc;
        }
    };

    /**
     * The getNumRows method.
     * 
     * This method returns the number of rows of the specified matrix.
     * 
     * @return The number of rows in this matrix.
     */
    public int getNumRows() {
        return data.length;
    };

    /**
     * The getNumCols method.
     * 
     * This method returns the number of columns of the specified matrix.
     * 
     * @return The number of columns in this matrix.
     */
    public int getNumColumns() {
        return data[0].length;
    };

    /**
     * The approxEqual method.
     * 
     * This element checks to see if two matrices are approximately equal. The
     * two matrices are equal if: A. They have the same number of rows. B. They
     * have the same number of columns and C. Corresponding elements are
     * approximately equal as determined by the epsilon test, which is Math.abs(
     * this-element - test-element ) < epsilon.
     * 
     * @param test    A matrix to compare to the internal array.
     * @param epsilon The epsilon test. See above for explanation.
     * @return A boolean value indicating whether or not the two matrices are
     *         approximately equal.
     * 
     */
    public boolean approxEqual(Matrix test, double epsilon) {
        Matrix currentMatrix = new Matrix(data);

        double[][] tester = test.data;
        double[][] current = currentMatrix.getData();

        boolean sameRows;
        boolean sameCols;

        if (currentMatrix.getNumRows() == test.getNumRows()) {
            sameRows = true;
        } else {
            sameRows = false;
        }
        if (currentMatrix.getNumColumns() == test.getNumColumns()) {
            sameCols = true;
        } else {
            sameCols = false;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (Math.abs(current[i][j] - tester[i][j]) >= epsilon) {
                    return false;
                }
                ;
            }
        }
        ;
        if (sameRows == true && sameCols == true) {
            return true;
        } else {
            return false;
        }
    };

    /**
     * The toString method for this class.
     * 
     * @return The formatted string representing the encapsulated data. The
     *         format of the string conforms to the details specified in the
     *         required toString Format detailed in the assignment outline.
     */
    public String toString() {

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        for (int i = 0; i < data.length; i++) {
            bldr.append("| ");
            for (int j = 0; j < data[i].length; j++) {
                bldr.append("").append(String.format("%7.3f", data[i][j]))
                    .append("");
            }
            bldr.append(" |");
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();

        String holder2 = holder;
        return holder2;
    };
}
