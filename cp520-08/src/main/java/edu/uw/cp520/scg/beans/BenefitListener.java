package edu.uw.cp520.scg.beans;

import java.util.EventListener;

/**
 * The BenefitListener class for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public interface BenefitListener extends EventListener {

    /**
     * The medicalEnrollment method for the BenefitListener interface.
     * 
     * @param evnt
     * 
     */
    void medicalEnrollment(BenefitEvent evnt);

    /**
     * The medicalCancellation method for the BenefitListener interface.
     * 
     * @param evnt
     * 
     */
    void medicalCancellation(BenefitEvent evnt);

    /**
     * The dentalEnrollment method for the BenefitListener interface.
     * 
     * @param evnt
     * 
     */
    void dentalEnrollment(BenefitEvent evnt);

    /**
     * The medicalCancellation method for the BenefitListener interface.
     * 
     * @param evnt
     */
    void dentalCancellation(BenefitEvent evnt);
}
