package cp510.assignments.assignment5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * The MatrixTest class to run JUnit tests for the Matrix class.
 * 
 * @author toby
 *
 */
public class MatrixTest {

    @BeforeEach
    void init() {
    }

    double[][] testArray1 = { { 3.695, 9.289, -2.560, -1.576, -5.650 },
            { -7.866, 2.923, 7.621, -4.176, 6.671 },
            { 4.723, -7.438, -0.754, 3.227, 7.886 },
            { 1.312, -4.497, -6.915, 3.736, -2.881 },
            { 5.549, 9.965, -3.170, 1.302, -6.499 } };

    double[][] testArray2 = { { 3.695, 9.289, -2.560, -1.576, -5.650 },
            { -7.866, 2.923, 7.621, -4.176, 6.671 },
            { 4.723, -7.438, -0.754, 3.227, 7.886 },
            { 1.312, -4.497, -6.915, 3.736, -2.881 },
            { 5.549, 9.965, -3.170, 1.302, -6.499 } };

    double[][] problematicArray = { { 3.695, 9.289, -2.560, -1.576 },
            { -7.866, 2.923, 7.621, -4.176 } };

    double[][] problematicArray2 = { { 3.695, 9.289, -2.560, -1.576 },
            { -7.866, 2.923, 7.621 } };

    Matrix test1 = new Matrix(testArray1);
    Matrix test2 = new Matrix(testArray2);

    Boolean areTheyEqual = test1.approxEqual(test2, 1);

    double testElement = test1.getElement(1, 2);
    double[] row = test1.getRow(0);

    Matrix newMatrix;
    String holder;

    String addResult = "|   7.390 18.578 -5.120 -3.152-11.300 |\n"
        + "| -15.732  5.846 15.242 -8.352 13.342 |\n"
        + "|   9.446-14.876 -1.508  6.454 15.772 |\n"
        + "|   2.624 -8.994-13.830  7.472 -5.762 |\n"
        + "|  11.098 19.930 -6.340  2.604-12.998 |\n";

    String subResult = "|   0.000  0.000  0.000  0.000  0.000 |\n"
        + "|   0.000  0.000  0.000  0.000  0.000 |\n"
        + "|   0.000  0.000  0.000  0.000  0.000 |\n"
        + "|   0.000  0.000  0.000  0.000  0.000 |\n"
        + "|   0.000  0.000  0.000  0.000  0.000 |\n";

    String productResult1 = "| -104.925 31.301 92.071-66.120 62.162 |\n"
        + "|  15.475-35.952 44.397 17.867 92.718 |\n"
        + "| 120.391 91.811-115.521 43.508-142.798 |\n"
        + "|  -3.523  4.966-49.118  4.604-83.984 |\n"
        + "| -107.208 33.633 75.727-64.186 48.612 |\n";

    String testNegate = "|  -3.695 -9.289  2.560  1.576  5.650 |\n"
        + "|   7.866 -2.923 -7.621  4.176 -6.671 |\n"
        + "|  -4.723  7.438  0.754 -3.227 -7.886 |\n"
        + "|  -1.312  4.497  6.915 -3.736  2.881 |\n"
        + "|  -5.549 -9.965  3.170 -1.302  6.499 |\n";

    String testMultiplyScalar = "|  14.780 37.156-10.240 -6.304-22.600 |\n"
        + "| -31.464 11.692 30.484-16.704 26.684 |\n"
        + "|  18.892-29.752 -3.016 12.908 31.544 |\n"
        + "|   5.248-17.988-27.660 14.944-11.524 |\n"
        + "|  22.196 39.860-12.680  5.208-25.996 |\n";

    @BeforeEach
    void setup() {
        newMatrix = new Matrix(testArray1);
    }

    @Test
    void getData() {

        Assertions.assertEquals(testArray1, test1.getData());
    }

    @Test
    void getNumRows() {

        Assertions.assertEquals(testArray1.length, test1.getNumRows());
    }

    @Test
    void getNumColumns() {

        Assertions.assertEquals(testArray1[0].length, test1.getNumColumns());
    }

    @Test
    void approxEqualt() {
        Assertions.assertEquals(true, test1.approxEqual(test2, 1));
        Assertions.assertEquals(false, test2.approxEqual(test1, 0));

    }

    @Test
    void getRow() {
        test1.getRow(0);
        Assertions.assertEquals(testArray1[0], test1.getRow(0));
    }

    @Test
    void getColumn() {
        Assertions.assertEquals(testArray2[0], test2.getCol(0));
    }

    @Test
    void getElement() {
        Assertions.assertEquals(7.621, testElement);

    }

    @Test
    void add() {
        assertTrue(addResult.contains(newMatrix.add(test2).toString()));
    }

    @Test
    void subtract() {
        assertTrue(subResult.contains(newMatrix.subtract(test2).toString()));
    }

    @Test
    void multiply() {
        Assertions.assertEquals(productResult1,
            test1.multiply(test2).toString());
    }

    @Test
    void multiplyScalar() {
        assertTrue(testMultiplyScalar.contains(test1.multiply(4).toString()));
    }

    @Test
    void negate() {
        assertTrue(testNegate.contains(newMatrix.negate().toString()));
    }

    @Test
    void testExpectedExceptionAdd() {

        final Matrix badMatrix = new Matrix(problematicArray);
        Assertions.assertThrows(MatrixException.class, new Executable() {
            public void execute() throws Throwable {
                test1.add(badMatrix);
            }
        });

    }

    @Test
    void testExpectedExceptionSub() {

        final Matrix badMatrix = new Matrix(problematicArray);
        Assertions.assertThrows(MatrixException.class, new Executable() {
            public void execute() throws Throwable {
                test1.subtract(badMatrix);
            }
        });

    }

    @Test
    void testExpectedExceptionMultiply() {

        final Matrix badMatrix = new Matrix(problematicArray);
        Assertions.assertThrows(MatrixException.class, new Executable() {
            public void execute() throws Throwable {
                test1.multiply(badMatrix);
            }
        });

    }

    @Test
    void testExpectedExceptionGetElement() {

        final Matrix badMatrix = new Matrix(problematicArray);

        Assertions.assertThrows(IndexOutOfBoundsException.class,
            new Executable() {
                public void execute() throws Throwable {
                    badMatrix.getElement(4, 9);
                }
            });

    }

    @Test
    void testExpectedExceptionGetRow() {

        final Matrix badMatrix = new Matrix(problematicArray);

        Assertions.assertThrows(IndexOutOfBoundsException.class,
            new Executable() {
                public void execute() throws Throwable {
                    badMatrix.getRow(12);
                }
            });

    }

    @Test
    void testExpectedExceptionGetCol() {

        final Matrix badMatrix = new Matrix(problematicArray);

        Assertions.assertThrows(IndexOutOfBoundsException.class,
            new Executable() {
                public void execute() throws Throwable {
                    badMatrix.getCol(12);
                }
            });
    }

    @Test
    void testExpectedExceptionApproxEqual() {

        final Matrix badMatrix = new Matrix(problematicArray);
        Assertions.assertEquals(false, badMatrix.approxEqual(test1, 3));
    }

    @Test
    void testExpectedExceptionBadConstructor() {

        Assertions.assertThrows(MatrixException.class, new Executable() {
            public void execute() throws Throwable {
                final Matrix badMatrix = new Matrix(problematicArray2);

                badMatrix.approxEqual(test1, 3);
            }
        });
    }

}