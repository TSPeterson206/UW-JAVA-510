package edu.uw.cp520.scg.beans;

import java.beans.PropertyVetoException;
import java.time.LocalDate;

import javax.swing.event.EventListenerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uw.cp520.scg.domain.Consultant;

/**
 * The HumanResourceManager class for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class HumanResourceManager {

    /**
     * The logger property.
     */
    private static final Logger log = LoggerFactory
        .getLogger(HumanResourceManager.class);

    /**
     * The listenerList that contains the added listeners.
     */
    private EventListenerList listenerList = new EventListenerList();

    /**
     * The constructor for the HumanResourceManager class.
     */
    public HumanResourceManager() {
    }

    /**
     * The adjustPayRate method for the HumanResourceManager class. It sets the
     * pay rate for a staff consultant and logs whether the pay rate change was
     * approved or rejected (vetoed).
     * 
     * @param c          The consultant that will receive the adjustment.
     * @param newPayRate The new pay rate that is being proposed.
     * @throws PropertyVetoException The exception that will be thrown if the
     *                               pay change is vetoed.
     */
    public void adjustPayRate​(StaffConsultant c, int newPayRate)
        throws PropertyVetoException {
        double percentage = ((c.getPayRate() * 0.05) / c.getPayRate());
        log.info("% change =(" + newPayRate + "-" + c.getPayRate() + ")/"
            + c.getPayRate() + "=" + percentage);

        try {
            c.setPayRate​(newPayRate);
            log.info("Approved pay adjustment for " + c.getName().toString());
        } catch (PropertyVetoException e) {
            log.info("Denied pay adjustment for " + c.getName().toString());
        }
    }

    /**
     * The adjustSickLeaveHours method.
     * 
     * @param c                 The consultant to adjust the hours for.
     * @param newSickLeaveHours The new sickleave hours.
     * @throws PropertyVetoException The exception thrown.
     */
    public void adjustSickLeaveHours​(StaffConsultant c, int newSickLeaveHours)
        throws PropertyVetoException {
        c.setSickLeaveHours​(newSickLeaveHours);
    }

    /**
     * The adjustVacationHours method.
     * 
     * @param c                The consultant to adjust the hours for.
     * @param newVacationHours The new sickleave hours.
     */
    public void adjustVacationHours​(StaffConsultant c, int newVacationHours) {
        c.setVacationHours​(newVacationHours);
    }

    /**
     * The acceptResignation method.It accepts the resignation of a consultant
     * and fires a voluntary termination event for the consultant.
     * 
     * 
     * @param c The consultant that will resign.
     */
    public void acceptResignation​(Consultant c) {
        TerminationListener[] employmentListeners = listenerList
            .getListeners(TerminationListener.class);
        for (TerminationListener listener : employmentListeners) {
            listener.voluntaryTermination​(new TerminationEvent(this, c, true));
        }
    }

    /**
     * The terminate method.It accepts the termination of a consultant and fires
     * a involuntary termination event for the consultant.
     * 
     * 
     * @param c The consultant that will be terminated.
     */
    public void terminate​(Consultant c) {
        TerminationListener[] employmentListeners = listenerList
            .getListeners(TerminationListener.class);
        for (TerminationListener listener : employmentListeners) {
            listener.forcedTermination​(new TerminationEvent(this, c, false));
        }
    }

    /**
     * The enrollMedical method.
     * 
     * @param c The consultant that will enroll in medical.
     */
    public void enrollMedical​(Consultant c) {
        BenefitListener[] benefitListeners = listenerList
            .getListeners(BenefitListener.class);
        for (BenefitListener listener : benefitListeners) {
            listener
                .medicalEnrollment(new BenefitEvent(this, c, LocalDate.now()));
        }
    }

    /**
     * The cancelMedical method.
     * 
     * @param c The consultant that will cancel medical.
     */
    public void cancelMedical​(Consultant c) {
        BenefitListener[] benefitListeners = listenerList
            .getListeners(BenefitListener.class);
        for (BenefitListener listener : benefitListeners) {
            listener.medicalCancellation(
                new BenefitEvent(this, c, LocalDate.now()));
        }
    }

    /**
     * The enrollDental method.
     * 
     * @param c The consultant that will enroll in dental.
     */
    public void enrollDental​(Consultant c) {
        BenefitListener[] benefitListeners = listenerList
            .getListeners(BenefitListener.class);
        for (BenefitListener listener : benefitListeners) {
            listener
                .dentalEnrollment(new BenefitEvent(this, c, LocalDate.now()));
        }
    }

    /**
     * The cancelDental method.
     * 
     * @param c The consultant that will cancel their dental benefit.
     */
    public void cancelDental​(Consultant c) {
        BenefitListener[] benefitListeners = listenerList
            .getListeners(BenefitListener.class);
        for (BenefitListener listener : benefitListeners) {
            listener
                .dentalCancellation(new BenefitEvent(this, c, LocalDate.now()));
        }
    }

    /**
     * The addBenefitListener method.
     * 
     * @param l The BenefitListener to be added to the class.
     */
    public void addBenefitListener​(BenefitListener l) {
        listenerList.add(BenefitListener.class, l);
    }

    /**
     * The removeBenefitListener method.
     * 
     * @param l The BenefitListener to be removed from the class.
     */
    public void removeBenefitListener​(BenefitListener l) {
        listenerList.remove(BenefitListener.class, l);
    }

    /**
     * The addTerminationListener method.
     * 
     * @param l The TerminationListener to be added to the class.
     */
    public void addTerminationListener​(TerminationListener l) {
        listenerList.add(TerminationListener.class, l);
    }

    /**
     * The removeTerminationListener method.
     * 
     * @param l The TerminationListener to be removed from the class.
     */
    public void removeTerminationListener​(TerminationListener l) {
        listenerList.remove(TerminationListener.class, l);

    }
}
