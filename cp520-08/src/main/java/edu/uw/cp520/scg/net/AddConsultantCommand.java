package edu.uw.cp520.scg.net;

import java.io.Serializable;

import edu.uw.cp520.scg.domain.Consultant;

/**
 * The AddConsultantCommand class for the project. It extends AbstractCommand.
 * 
 * @author Toby Peterson.
 *
 */
public class AddConsultantCommand extends AbstractCommand<Consultant>
    implements Serializable {

    /**
     * The receiver property.
     */
    private Receiver recvr;

    /**
     * The target/consultant property
     */
    private Consultant target;

    /**
     * The contructor for the AddConsultantCommand class.
     * 
     * @param target The target property.
     */
    public AddConsultantCommand(Consultant target) {
        this.target = target;
    };

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
        recvr.execute(this);
    }

    /**
     * The getReceiver getter method for the class.
     * 
     * @return Receiver The returned receiver.
     */
    @Override
    public Receiver getReceiver() {
        return recvr;
    }

    /**
     * The getTarget getter method for the class.
     * 
     * @return Object The returned target object.
     */
    @Override
    public Consultant getTarget() {
        return target;
    }
}
