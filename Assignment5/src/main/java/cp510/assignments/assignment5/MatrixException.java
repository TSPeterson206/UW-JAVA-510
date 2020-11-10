package cp510.assignments.assignment5;

public class MatrixException extends RuntimeException {

    public static void main(String[] args) {
        System.out.println("Expected exception caught");
    }

    public MatrixException() {
    }

    public MatrixException(String msg) {
        super(msg);
    }

    public MatrixException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }

//    public class MatrixException 
//    This class encapsulates an exception to be thrown when an error is encountered while performing a matrix operation. It adds no new properties or methods to those inherited from its superclass. It contains the following constructors.
//
//    Constructors
//    The four constructors described in your class notes.
//
//    cp510.assignments.assignment5
//    public class Matrix
//    This class encapsulates a matrix, and is capable of performing simple matrix operations. It has the following property, constructor and methods:

}
