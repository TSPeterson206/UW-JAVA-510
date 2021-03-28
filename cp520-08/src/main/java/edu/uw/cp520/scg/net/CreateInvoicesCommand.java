package edu.uw.cp520.scg.net;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The CreateInvoicesCommand class for the project. It extends AbstractCommand.
 * 
 * @author Toby Peterson.
 *
 */
public class CreateInvoicesCommand extends AbstractCommand<LocalDate>
    implements Serializable {

    /**
     * The receiver property.
     */
    private Receiver recvr;

    /**
     * The target property.
     */
    private LocalDate target;

    /**
     * The contructor for the ShutdownCommand class.
     * 
     * @param target The date to be used.
     */
    public CreateInvoicesCommand(LocalDate target) {
        this.target = target;
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
    public LocalDate getTarget() {
        return target;
    }

}
