package edu.uw.cp520.scg.net;

import java.io.Serializable;

/**
 * The AddClientCommand class. It extends the AbstractCommand class.
 * 
 * @author Toby Peterson.
 *
 */
public class SetOutputDirectoryCommand extends AbstractCommand<Object>
    implements Serializable {

    /**
     * The receiver property.
     */
    private Receiver recvr;

    /**
     * The target property.
     */
    private String target;

    /**
     * The AddClientCommand constructor.
     * 
     * @param target The target.
     */
    public SetOutputDirectoryCommand(String target) {
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
        try {
            recvr.execute(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public String getTarget() {
        return target;
    }

}
