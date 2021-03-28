package edu.uw.cp520.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.EventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CompensationManager class for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class CompensationManager
    implements PropertyChangeListener, VetoableChangeListener, EventListener {

    /**
     * The logger property.
     */
    private static final Logger log = LoggerFactory
        .getLogger(CompensationManager.class);

    /**
     * The constructor for the CompensationManager class.
     */
    public CompensationManager() {
    }

    /**
     * The vetoableChange method for the CompensationManager class.
     * 
     * @param arg0 The propertyChangeEvent being passed in.
     */
    @Override
    public void vetoableChange(PropertyChangeEvent arg0)
        throws PropertyVetoException {
        double newValue = 0;
        double oldValue = 0;

        if ("payRate".equals(arg0.getPropertyName())) {
            newValue = (int) arg0.getNewValue();
            oldValue = (int) arg0.getOldValue();
        }

        double limit = (oldValue * 0.05) + oldValue;

        if (newValue > limit) {
            log.info("REJECTED pay rate change, from " + oldValue + " to "
                + newValue + " for " + arg0.getSource().toString());
//            log.info("REJECTED pay rate change, from " + oldValue + " to "
//                + newValue + " for " + arg0.getSource().toString());

//            INFO: REJECTED pay rate change, from 10000 to 10501 for Coder, Kalvin NMN

            throw new PropertyVetoException(
                "That is more than 5%. We aren't made of money!", arg0);
        } else {
            log.info("APPROVED pay rate change from " + oldValue + " to "
                + newValue + " for " + arg0.getSource().toString());
        }

    }
//  Rejects any raise over 5%.

    /**
     * The propertyChange method. It simply logs the change.
     */
    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        if (arg0.getPropertyName() == "payRate") {
            log.info("Pay rate changed, from " + arg0.getOldValue() + " to "
                + arg0.getNewValue() + " for " + arg0.getSource().toString());
        }
        ;
    }

}
