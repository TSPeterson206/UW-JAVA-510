package edu.uw.cp520.scg.beans;

import java.time.LocalDate;
import java.util.EventObject;
import java.util.Optional;

import edu.uw.cp520.scg.domain.Consultant;

/**
 * The BenefitEvent class for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class BenefitEvent extends EventObject implements java.io.Serializable {

    /**
     * The consultant that is the subject of this BenefitEvent.
     */
    private Consultant consultant;

    /**
     * The effective date that the event takes place.
     */
    private LocalDate effectiveDate;

    /**
     * The boolean that determines if the consultant is enrolled in dental or
     * not.
     */
    private static boolean dental;

    /**
     * The boolean that determines if the consultant is enrolled in medical or
     * not.
     */
    private static boolean medical;

    /**
     * The constructor for the BenefitEvent class.
     * 
     * @param source        The source of the event.
     * @param consultant    The consultant for the BenefitEvent.
     * @param effectiveDate The effective date of the event.
     */
    public BenefitEvent(Object source, Consultant consultant,
        LocalDate effectiveDate) {
        super(source);
        this.consultant = consultant;
        this.effectiveDate = effectiveDate;
    }

    /**
     * The enrollMedical method for the BenefitEvent class
     * 
     * @param source        The source for the event being passed in.
     * @param consultant    The consultant for the event being passed in.
     * @param effectiveDate The effective date for the event being passed in,
     * @return BenefitEvent The BenefitEvent to be fired.
     */
    public static BenefitEvent enrollMedical​(Object source,
        Consultant consultant, LocalDate effectiveDate) {
        medical = true;
        return new BenefitEvent(source, consultant, effectiveDate);
    }

    /**
     * The cancelMedical method for the BenefitEvent class
     * 
     * @param source        The source for the event being passed in.
     * @param consultant    The consultant for the event being passed in.
     * @param effectiveDate The effective date for the event being passed in,
     * @return BenefitEvent The BenefitEvent to be fired.
     */
    public static BenefitEvent cancelMedical​(Object source,
        Consultant consultant, LocalDate effectiveDate) {
        medical = false;
        return new BenefitEvent(source, consultant, effectiveDate);

    }

    /**
     * The enrollDental method for the BenefitEvent class
     * 
     * @param source        The source for the event being passed in.
     * @param consultant    The consultant for the event being passed in.
     * @param effectiveDate The effective date for the event being passed in,
     * @return BenefitEvent The BenefitEvent to be fired.
     */
    public static BenefitEvent enrollDental​(Object source,
        Consultant consultant, LocalDate effectiveDate) {
        dental = true;
        return new BenefitEvent(source, consultant, effectiveDate);

    }

    /**
     * The cancelDental method for the BenefitEvent class
     * 
     * @param source        The source for the event being passed in.
     * @param consultant    The consultant for the event being passed in.
     * @param effectiveDate The effective date for the event being passed in,
     * @return BenefitEvent The BenefitEvent to be fired.
     */
    public static BenefitEvent cancelDental​(Object source,
        Consultant consultant, LocalDate effectiveDate) {
        dental = false;
        return new BenefitEvent(source, consultant, effectiveDate);

    }

    /**
     * The getConsultant getter for the BenefitEvent class.
     * 
     * @return Consultant The consultant object for this class.
     */
    public Consultant getConsultant() {
        return consultant;
    }

    /**
     * The getDentalStatus methof. It gets the dental enrollment status.
     * 
     * @return boolean A boolean determining whether the consultant is enrolled
     *         or not.
     */
    public Optional<Boolean> getDentalStatus() {
        return Optional.of(dental);
    }

    /**
     * The getEffectiveDate method.
     * 
     * @return LocalDate The effective date of the event.
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * The getMedicalStatus methof. It gets the medical enrollment status.
     * 
     * @return boolean A boolean determining whether the consultant is enrolled
     *         or not.
     */
    public Optional<Boolean> getMedicalStatus() {
        return Optional.of(medical);
    }

}
