package cp510.assignments.assignment5;

import java.util.Arrays;

public class Matrix {

    public double[][] data;
    public Matrix currentMatrix;
    String holder;
    double[][] acc;
    double multiplied = 0;

//  A two-dimensional array of doubles representing the data stored in the matrix.

//  Constructor:
    public Matrix(double[][] dataIn) throws MatrixException {

        data = dataIn;

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

//        System.out.println("beginning of arrays");
        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                bldr.append(String.format("%05.3f", dataIn[i][j]));
            }
            bldr.append(newl);
//            System.out.println(Arrays.toString(dataIn[i]));
        }
        ;
        holder = bldr.toString();
//        System.out.println("end of arrays");
        data = dataIn;

        System.out.println("rows" + getNumRows());
        System.out.println("columns" + getNumColumns());
        int rows = getNumRows();
        int cols = getNumColumns();

        acc = new double[rows][cols];
    };

//  Creates a matrix object from the given input. Throw MatrixException if the array is not rectangular (i.e. if rows have different lengths).
//  dataIn
//  The given input.

//  Methods:
    public Matrix add(Matrix toAdd) throws MatrixException {
        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

//        System.out.println("currentmatix in add: " + currentMatrix);

        double[][] added = toAdd.data;
//        System.out.println(
//        "This is what is being added" + Arrays.toString(toAdd.data[0]));
//        System.out
//        .println("This is the current matrix" + Arrays.toString(data[0]));

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
//                double test = data[i][j] + added[i][j];
                acc[i][j] = data[i][j] + added[i][j];

                bldr.append(String.format("%05.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        currentMatrix = new Matrix(acc);
        return currentMatrix;
    };
//  Adds a given matrix to this matrix. The result is a new matrix object. Throws MatrixException if this matrix and the given matrix have different dimensions.
//  toAdd
//  The given matrix.

//  returns:
//  A new matrix which is the sum of this matrix and the given matrix.

    public Matrix subtract(Matrix toSub) throws MatrixException {
        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

//        System.out.println("currentmatix in add: " + currentMatrix);

        double[][] added = toSub.data;
//        System.out.println(
//        "This is what is being added" + Arrays.toString(toAdd.data[0]));
//        System.out
//        .println("This is the current matrix" + Arrays.toString(data[0]));

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                acc[i][j] = data[i][j] - added[i][j];
//                acc[i][j] = -1 * added[i][j];

                bldr.append(String.format("%05.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        currentMatrix = new Matrix(acc);
        return currentMatrix;
    };
//  Subtracts a given matrix from this matrix. The result is a new matrix object. Throws MatrixException if this matrix and the given matrix have different dimensions.
//  toSub
//  The given matrix.
//
//  Returns:
//  A new matrix which is the difference of this matrix and the given matrix.

    public Matrix multiply(Matrix toMul) throws MatrixException {

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        double[][] added = toMul.data;

        System.out.println("hitting multiply1" + Arrays.toString(added[0]));
        System.out.println("hitting multiply2" + Arrays.toString(data[0]));

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {

                multiplied += data[i][j] * added[j][0];
                System.out.println("multiplied: " + "i " + i + "j " + j
                + data[i][j] + "," + added[j][0] + "," + multiplied);
            }
        }
        ;
        bldr.append(String.format("%05.3f", multiplied));

        holder = bldr.toString();
        System.out.println("multiply holder" + holder);
//        holder = "" + multiplied;
        currentMatrix = new Matrix(acc);
        return currentMatrix;
    };

    public Matrix multiply(double scalar) {
        System.out.println("scalar" + scalar);
        Matrix currentMatrix = new Matrix(data);

        return currentMatrix;
    };
//  Multiplies this matrix by a given scalar. The result is a new matrix object.
//  scalar
//  The given scalar.
//
//  Returns:
//  A new matrix which is the scalar product of this matrix and the given scalar.

    public Matrix negate() {

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        for (int i = 0; i < data.length; i++) {
//            System.out.println("to sub " + Arrays.toString(data[0]));

            for (int j = 0; j < data[i].length; j++) {
//                acc[i][j] = data[i][j] - added[i][j];
                acc[i][j] = -1 * data[i][j];

                bldr.append(String.format("%05.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        currentMatrix = new Matrix(acc);
        return currentMatrix;
    };
//  Returns a new matrix which is the negation of this matrix.
//
//  Returns:
//  A new matrix which is the negation of this matrix.

    public double getElement(int row, int col)
    throws IndexOutOfBoundsException {

        try {
            return data[row][col];
        } catch (IndexOutOfBoundsException exc) {
            throw new IndexOutOfBoundsException();
        }

    };
//  Returns the value of the element at a given row and column. Throws IndexOutOfBoundsException if the row or column are out of range.
//  row
//  The given row.
//
//  col
//  The given column.
//
//  Returns:
//  The value of the element at the given row and column.

    public double[][] getData() {
        return this.data;
    };
//  Returns an array which is a copy of the internal array.
//
//  Returns:
//  An array which is a copy of the internal array.

    public double[] getRow(int row) throws IndexOutOfBoundsException {
        try {
            return data[row];
        } catch (IndexOutOfBoundsException exc) {
            throw exc;
        }
    };
//  Returns a one-dimensional array containing a copy of the given row. Throws IndexOutOfBoundsException if the given row is out of range.
//  row
//  The given row.
//
//  Returns:
//  A one-dimensional array containing a copy of the given row. 

    public double[] getCol(int col) throws IndexOutOfBoundsException {

        try {
            return data[col];
        } catch (IndexOutOfBoundsException exc) {
            throw exc;
        }

    };
//  Returns a one-dimensional array reflecting the data in the given column. Throws IndexOutOfBoundsException if the given column is out of range.
//  col
//  The given column.
//
//  Returns:
//  A one-dimensional array reflecting the data in the given column.

    public int getNumRows() {
        return data.length;
    };
//  Returns the number of rows in this matrix.
//  Returns:
//  The number of rows in this matrix.

    public int getNumColumns() {
        return data[0].length;
    };
//  Returns the number of columns in this matrix.
//  Returns:
//  The number of columns in this matrix.

    public boolean approxEqual(Matrix test, double epsilon) {
        return true;
    };
//  Returns true if this matrix is approximately equal to a given matrix. The two matrices are equal if:
//  They have the same number of rows.
//  They have the same number of columns.
//  Corresponding elements are approximately equal as determined by the epsilon test: Math.abs( this-element - test-element ) < epsilon.
//
//
//  test
//  The given matrix.
//
//  Returns:
//  True, if this matrix is approximately equal to the given matrix according to the above criteria; false otherwise.

    public String toString() {

//        for (int i = 0; i < toAdd.length; i++) {
//            System.out.println("arr[" + i + "][" + j + "] = " + dataIn[i][j]);
//        }

        return holder;
    };
//  Returns a formatted string representing the encapsulated data. The format of the string must conform to the details specified in Required toString Format, above.
//  Returns:
//  A formatted string representing the encapsulated data.

}

//-7.409  34.447  34.4116   -1.096  45.567
