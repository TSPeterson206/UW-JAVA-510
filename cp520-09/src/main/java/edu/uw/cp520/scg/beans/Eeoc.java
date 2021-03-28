package edu.uw.cp520.scg.beans;

import java.beans.PropertyChangeSupport;
import java.util.EventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Eeoc class for the Invoice/Timecard paroject.
 * 
 * @author Toby Peterson.
 *
 */
public class Eeoc
    implements TerminationListener, EventListener, java.io.Serializable {

    /**
     * The voluntary termination count.
     */
    private int volTermCount;

    /**
     * The forced termination count.
     */
    private int forTermCount;

    /**
     * The logger property.
     */
    private static final Logger log = LoggerFactory.getLogger(Eeoc.class);
    final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * The constructor for the Eeoc class.
     */
    public Eeoc() {
        this.volTermCount = 0;
        this.forTermCount = 0;
    }

    /**
     * The voluntaryTermination method for the Eeoc class. It simply prints a
     * message indicating that the consultant quit and adjusts the voluntary
     * termination count.
     * 
     * 
     * @param evt The TerminationEvent being passed in.
     * 
     */
    public void voluntaryTermination​(TerminationEvent evt) {
        this.volTermCount++;
        String consultant = evt.getConsultant().getName().toString();
        log.info(consultant + " has quit");
    }

    /**
     * The forcedTermination method for the Eeoc class. It simply prints a
     * message indicating that the consultant was fired and adjusts the forced
     * termination count.
     * 
     * @param evt The TerminationEvent being passed in.
     * 
     */
    public void forcedTermination​(TerminationEvent evt) {
        forTermCount++;
        String consultant = evt.getConsultant().getName().toString();
        log.info(consultant + " has been fired");
    }

    /**
     * The forcedTerminationCount method for the Eeoc class.
     * 
     * @return int The forced termination count.
     */
    public int forcedTerminationCount() {
        return this.forTermCount;
    }

    /**
     * * The voluntaryTerminationCount method for the Eeoc class.
     * 
     * @return int The voluntary termination count.
     */
    public int voluntaryTerminationCount() {
        return this.volTermCount;
    }
}
