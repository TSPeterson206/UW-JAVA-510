package edu.uw.cp520.scg.net;

import java.io.Serializable;

/**
 * The ShutdownCommand class for the project. It extends AbstractCommand.
 * 
 * @author Toby Peterson.
 *
 */
public class ShutdownCommand extends AbstractCommand<Object>
    implements Serializable {

    /**
     * The receiver property.
     */
    private Receiver recvr;

    /**
     * The contructor for the ShutdownCommand class.
     */
    public ShutdownCommand() {
        super();
    }

    /**
     * The setReceiver setter method for the class.
     * 
     * @param recvr The receiver to be assigned.
     */
    public void setReceiver(Receiver recvr) {
        this.recvr = recvr;
    }

    /**
     * The execute method. Executes the command with itself as the content.
     */
    public void execute() {
        try {
            recvr.execute(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
