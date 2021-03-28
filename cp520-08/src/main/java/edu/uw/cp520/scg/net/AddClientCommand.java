package edu.uw.cp520.scg.net;

import java.io.Serializable;

import edu.uw.cp520.scg.domain.ClientAccount;

/**
 * The AddClientCommand class. It extends the AbstractCommand class.
 * 
 * @author Toby Peterson.
 *
 */
public class AddClientCommand extends AbstractCommand<ClientAccount>
    implements Serializable {

    /**
     * The receiver property.
     */
    private Receiver recvr;

    /**
     * The target property.
     */
    private ClientAccount target;

    /**
     * The AddClientCommand constructor.
     * 
     * @param target The target.
     */
    public AddClientCommand(ClientAccount target) {
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
    public ClientAccount getTarget() {
        return target;
    }

}
