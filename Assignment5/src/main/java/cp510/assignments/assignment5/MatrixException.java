package cp510.assignments.assignment5;

/**
 * The MatrixException for the Matrix class.
 * 
 * This exception is a subclass of the Matrix superclass. It contains various
 * constructors to detail the reason behind an exception being thrown.
 * 
 */
public class MatrixException extends RuntimeException {

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

}
