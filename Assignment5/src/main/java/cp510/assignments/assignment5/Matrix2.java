package cp510.assignments.assignment5;

public class Matrix2 {

    public double[][] data;
    String holder;
    public double[][] acc;
    int rows;
    int cols;

//  A two-dimensional array of doubles representing the data stored in the matrix.

//  Constructor:
    public Matrix2(double[][] dataIn) throws MatrixException {
        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                bldr.append(String.format("%05.3f", dataIn[i][j]));
            }
            bldr.append(newl);
//            System.out.println("constructor" + Arrays.toString(dataIn[i]));
        }
        ;
        holder = bldr.toString();
        data = dataIn;

        rows = getNumRows();
        cols = getNumColumns();

        acc = new double[rows][cols];
    };

//  Creates a matrix object from the given input. Throw MatrixException if the array is not rectangular (i.e. if rows have different lengths).
//  dataIn
//  The given input.

//  Methods:
    public Matrix2 add(Matrix2 toAdd) throws MatrixException {
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
        return new Matrix2(acc);
    };
//  Adds a given matrix to this matrix. The result is a new matrix object. Throws MatrixException if this matrix and the given matrix have different dimensions.
//  toAdd
//  The given matrix.

//  returns:
//  A new matrix which is the sum of this matrix and the given matrix.

    public Matrix2 subtract(Matrix2 toSub) throws MatrixException {
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
        return new Matrix2(acc);
    };
//  Subtracts a given matrix from this matrix. The result is a new matrix object. Throws MatrixException if this matrix and the given matrix have different dimensions.
//  toSub
//  The given matrix.

    public Matrix2 multiply(Matrix toMul) throws MatrixException {
        Matrix2 newMatrix = new Matrix2(data);

        int r1 = newMatrix.getNumRows(), c1 = newMatrix.getNumColumns();
        int r2 = toMul.getNumRows(), c2 = toMul.getNumColumns();

        double[][] current = newMatrix.getData();
        double[][] multi = toMul.data;
        double[][] product = new double[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += current[i][k] * multi[k][j];
                }
            }
        }
        return new Matrix2(product);
    };

    public Matrix2 multiply(double scalar) {
        Matrix2 newMatrix = new Matrix2(data);

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        double[][] newMatrixData = newMatrix.getData();

        for (int i = 0; i < newMatrixData.length; i++) {
            for (int j = 0; j < newMatrixData[i].length; j++) {
                newMatrixData[i][j] = newMatrixData[i][j] * scalar;

                bldr.append(String.format("%05.3f", acc[i][j]));
            }
            bldr.append(newl);
        }
        ;
        holder = bldr.toString();
        return new Matrix2(newMatrixData);
    };
//  Multiplies this matrix by a given scalar. The result is a new matrix object.
//  scalar
//  The given scalar.
//
//  Returns:
//  A new matrix which is the scalar product of this matrix and the given scalar.

    public Matrix2 negate() {

        Matrix2 newMatrix = new Matrix2(data);

        int r1 = newMatrix.getNumRows(), c1 = newMatrix.getNumColumns();
//        int r2 = toMul.getNumRows(), c2 = toMul.getNumColumns();

        double[][] current = newMatrix.getData();
        double[][] result = new double[r1][c1];

        StringBuilder bldr = new StringBuilder();
        String newl = System.lineSeparator();

        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[i].length; j++) {
//                System.out.println("to sub " + Arrays.toString(data[i]));
                result[i][j] = -1 * current[i][j];

                bldr.append(String.format("%05.3f", result[i][j]));
            }
            bldr.append(newl);
        }
        holder = bldr.toString();
        ;
        return new Matrix2(result);
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
        double[][] copy = this.data;
        return copy;
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

    public boolean approxEqual(Matrix2 test, double epsilon) {
        Matrix2 currentMatrix = new Matrix2(data);

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
        return holder;
    };
//  Returns a formatted string representing the encapsulated data. The format of the string must conform to the details specified in Required toString Format, above.
//  Returns:
//  A formatted string representing the encapsulated data.

}
