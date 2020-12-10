package cp510.assignments.assignment9;

/**
 * The ChessException exception for the project.
 * 
 * @author Toby Peterson
 *
 */
public class ChessException extends RuntimeException {

    /**
     * The default constructor for ChessException.
     */
    public ChessException() {
    }

    /**
     * @param msg The message to print.
     */
    public ChessException(String msg) {
        System.out.println(msg);
    }

    /**
     * @param cause
     */
    public ChessException(Throwable cause) {
    }

    /**
     * @param message
     * @param cause
     */
    public ChessException(String message, Throwable cause) {
    }

}

//An unchecked exception that
//is raised
//during the
//course of
//processing a
//chess game.This
//
//class has
//no properties
//and no methods.It implements
//the four
//constructors discussed
//in your
//
//class notes.