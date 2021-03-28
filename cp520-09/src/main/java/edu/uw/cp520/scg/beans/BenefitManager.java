package edu.uw.cp520.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The BenefitManager class for the Invoice/Timecard class.
 * 
 * @author Toby Peterson.
 *
 */
public class BenefitManager
    implements BenefitListener, PropertyChangeListener, EventListener {

    /**
     * The logger property.
     */
    private static final Logger log = LoggerFactory
        .getLogger(BenefitManager.class);

    /**
     * The constructor for the BenefitManager class.
     */
    public BenefitManager() {
    }

    /**
     * The propertyChange method. It simply logs the change.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evnt) {
        if (evnt.getPropertyName() == "vacationHours") {
            log.info("vacationHours changed from " + evnt.getOldValue() + " to "
                + evnt.getNewValue() + " for " + evnt.getSource());
        } else if (evnt.getPropertyName() == "sickLeaveHours") {
            log.info("sickLeaveHours changed from " + evnt.getOldValue()
                + " to " + evnt.getNewValue() + " for " + evnt.getSource());
        }
    }

    /**
     * The medicalEnrollment method for the BenefitManager class.
     * 
     * @param evnt The BenefitEvent being passed in.
     */
    @Override
    public void medicalEnrollment(BenefitEvent evnt) {
        log.info(evnt.getConsultant().getName().toString()
            + " enrolled in medical, " + evnt.getEffectiveDate());
    }

    /**
     * The medicalCancellation method for the BenefitManager class.
     * 
     * @param evnt The BenefitEvent being passed in.
     */
    @Override
    public void medicalCancellation(BenefitEvent evnt) {
        log.info(evnt.getConsultant().getName().toString()
            + " cancelled medical, " + evnt.getEffectiveDate());
    }

    /**
     * The dentalEnrollment method for the BenefitManager class.
     * 
     * @param evnt The BenefitEvent being passed in.
     */
    @Override
    public void dentalEnrollment(BenefitEvent evnt) {
        log.info(evnt.getConsultant().getName().toString()
            + " enrolled in dental, " + evnt.getEffectiveDate());
    }

    /**
     * The dentalCancellation method for the BenefitManager class.
     * 
     * @param evnt The BenefitEvent being passed in.
     */
    @Override
    public void dentalCancellation(BenefitEvent evnt) {
        log.info(evnt.getConsultant().getName().toString()
            + " cancelled dental, " + evnt.getEffectiveDate());
    }
}
