package edu.uw.cp520.scg.beans;

import java.util.EventListener;

/**
 * The TerminationListener interface for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public interface TerminationListener extends EventListener {

    /**
     * The voluntaryTermination method.
     * 
     * @param evt The event to be handled.
     */
    void voluntaryTermination​(TerminationEvent evt);

    /**
     * The forcedTermination method.
     * 
     * @param evt The event to be handled.
     */
    void forcedTermination​(TerminationEvent evt);
}
