package app;

import java.util.Random;

import cp510.assignments.assignment5.Matrix;

public class MatrixDriver {
    public static void main(String[] args) {
        Random randy = new Random(1);
        Matrix matrix3X5_1 = getMatrix(randy, 3, 5, 10);
        Matrix matrix3X5_2 = getMatrix(randy, 3, 5, 10);
        Matrix matrix6X4_1 = getMatrix(randy, 6, 4, 10);
        Matrix matrix6X4_2 = getMatrix(randy, 6, 4, 10);
        Matrix matrix1X5_1 = getMatrix(randy, 1, 5, 10);
        Matrix matrix1X5_2 = getMatrix(randy, 1, 5, 10);
        Matrix matrix5X1_1 = getMatrix(randy, 5, 1, 10);
        Matrix matrix5X1_2 = getMatrix(randy, 5, 1, 10);
        Matrix matrix5X5 = getMatrix(randy, 5, 5, 10);

        int num = 1;
        print(matrix3X5_1, matrix3X5_2, num++);
        print(matrix6X4_1, matrix6X4_2, num++);
        print(matrix1X5_1, matrix1X5_2, num++);
        print(matrix5X1_1, matrix5X1_2, num++);

        // product-related
        print(matrix1X5_1, matrix5X1_1, num++);
        print(matrix1X5_1, matrix1X5_1, num++);
        print(matrix5X5, matrix5X1_1, num++);
        print(matrix5X5, matrix5X5, num++);

        // One go-wronger
//        try {
//            matrix1X5_1.add(matrix5X1_1);
//            System.out.println("Expected exception; non thrown");
//        } catch (MatrixException exc) {
//            System.out.println("Expected exception caught");
//        }
    }

    private static void print(Matrix left, Matrix right, int ident) {
        final String startEndSeq = "******************************";
        final String prefix = "*** ";
        final int leftRows = left.getNumRows();
        final int leftCols = left.getNumColumns();
        final int rightRows = right.getNumRows();
        final int rightCols = right.getNumColumns();
        System.out.println(startEndSeq);

        System.out.println(prefix + "Left Matrix " + ident);
        System.out.println(left);
        System.out.println(prefix + "Right Matrix " + ident);
        System.out.println(right);

        Matrix result = null;
        if (leftRows == rightRows && leftCols == rightCols) {
//            System.out.println("hitting rows and columns equal: " + ident);
            result = left.add(right);
            System.out.println(prefix + "Sum " + ident);
            System.out.println(result);
            result = left.subtract(result);
            System.out.println(prefix + "Difference " + ident);
            System.out.println(result);
        }

        result = left.negate();
        System.out.println(prefix + "Negation " + ident);
        System.out.println(result);

        if (left.getNumColumns() == right.getNumRows()) {
            result = left.multiply(right);
            System.out.println(prefix + "Product " + ident);
            System.out.println(result);
        }

        System.out.println(startEndSeq);
    }

    private static Matrix getMatrix(Random randy, int rows, int cols,
    int xier) {
        double[][] data = getRandomData(randy, rows, cols, xier);
        Matrix matrix = new Matrix(data);
        return matrix;
    }

    private static double[][] getRandomData(Random randy, int rows, int cols,
    int xier) {
        double[][] data = new double[rows][cols];
        for (int inx = 0; inx < rows; ++inx)
            for (int jnx = 0; jnx < cols; ++jnx) {
                int sign = randy.nextBoolean() ? 1 : -1;
                data[inx][jnx] = randy.nextDouble() * xier * sign;
            }
        return data;
    }
}
