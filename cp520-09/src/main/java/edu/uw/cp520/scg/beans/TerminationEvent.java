package edu.uw.cp520.scg.beans;

import java.util.EventObject;

import edu.uw.cp520.scg.domain.Consultant;

/**
 * The TerminationEvent class for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class TerminationEvent extends EventObject
    implements java.io.Serializable {

    /**
     * The boolean that determines if the termination event is voluntary or not.
     */
    private boolean voluntary;

    /**
     * The consultant that is the subject of this termination event.
     */
    private Consultant consultant;

    /**
     * The TerminationEvent constructor.
     * 
     * @param source     The source to be used for the event.
     * @param consultant The consultant to be used for the event.
     * @param voluntary  The termination status for the event.
     */
    public TerminationEvent(Object source, Consultant consultant,
        boolean voluntary) {
        super(source);
        this.consultant = consultant;
        this.voluntary = voluntary;
    }

    /**
     * The isVoluntary method for the TerminationEvent class.
     * 
     * @return boolean A boolean determining whether or not the termination is
     *         voluntary or not.
     */
    public boolean isVoluntary() {
        return voluntary;
    }

    /**
     * The getConsultant getter for the TerminationEvent.
     * 
     * @return Consultant The consultant that is the subject of the
     *         TerminationEvent.
     */
    public Consultant getConsultant() {
        return consultant;
    }
}
