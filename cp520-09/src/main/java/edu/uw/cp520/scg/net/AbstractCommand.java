package edu.uw.cp520.scg.net;

/**
 * The AbstractCommand class for the project.
 * 
 * @author Toby Peterson.
 *
 * @param <T> The generic Type argument for the class.
 */
public abstract class AbstractCommand<T> implements Command<T> {

    /**
     * The receiver property.
     */
    private transient Receiver receiver;

    /**
     * The target property.
     */
    private T target;

    /**
     * The abstractCommand constructor.
     */
    public AbstractCommand() {
    }

    /**
     * The parameterized constructor for AbstractCommand.
     * 
     * @param <T>    The generic Type argument.
     * @param target The target for the command.
     */
    public <T> AbstractCommand(T target) {
    }

    /**
     * The getReceiver method. Returns the receiver.
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

    /**
     * The setReceiver method for the AbstractCommand class.
     * 
     * @param receiver The receiver to be assigned.
     */
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * The getTarget method for the AbstractCommand class.
     * 
     * @return T The target.
     * 
     */
    public T getTarget() {
        return this.target;
    }

    /**
     * The toString method for the class.
     * 
     * @return String The output string.
     */
    @Override
    public String toString() {
        return "The abstract command: " + getTarget();
    }

    /**
     * The execute method.
     */
    @Override
    public void execute() {
    }
}
