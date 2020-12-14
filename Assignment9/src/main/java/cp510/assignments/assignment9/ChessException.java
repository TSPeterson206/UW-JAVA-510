package cp510.assignments.assignment9;

/**
 * The ChessException exception for the project. There are four constructors
 * within this class that take various types of input.
 * 
 * @author Toby Peterson.
 *
 */
public class ChessException extends RuntimeException {

    /**
     * The default constructor for ChessException.
     */
    public ChessException() {
        System.out.println(
            "You hit the ChessException default constructor. The program takes exception to your input.");
    }

    /**
     * The one-parameter constructor for ChessException. This one parameter is a
     * string that is printed to the console upon invocation.
     * 
     * @param message The message to print.
     */
    public ChessException(String message) {
        super(message);
    }

    /**
     * The one-parameter constructor for ChessException. This one parameter is a
     * throwable that is fed to the constructor at the point of invocation.
     * 
     * @param cause The cause to be thrown.
     */
    public ChessException(Throwable cause) {
        super(cause);
    }

    /**
     * The two-parameter constructor for ChessException. These two parameters
     * are a string message to print and a throwable.
     * 
     * @param message The message to print.
     * @param cause   The cause to be thrown.
     */
    public ChessException(String message, Throwable cause) {
        super(message, cause);
    }

}