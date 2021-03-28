package edu.uw.cp520.scg.net;

/**
 * The command interface for the command pattern portion of the invoice/timecard
 * project.
 * 
 * @author Toby Peterson.
 *
 * @param <T> The generic Type argument.
 */
public interface Command<T> {

    /**
     * The execute method. Used to execute the selected command.
     */
    void execute();

    /**
     * The setReceiver setter for the command. Sets the receiver.
     * 
     * @param r
     */
    void setReceiver(Receiver r);

    /**
     * The getReceiver getter for the command. Returns the receiver that is
     * assigned to the command.
     * 
     * @return Receiver The assigned receiver.
     */
    Receiver getReceiver();

    /**
     * The getTarget method to be implemented.
     * 
     * @return The assigned target for the command.
     */
    T getTarget();
}
