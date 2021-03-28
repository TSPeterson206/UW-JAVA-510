package edu.uw.cp520.scg.domain;

import java.time.LocalDate;

/**
 * The InvoiceLineItem class for the Invoice/TimeCard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceLineItem {

    /**
     * The date property.
     */
    private LocalDate date;

    /**
     * The skill property.
     */
    private Skill skill;

    /**
     * The hours property.
     */
    private int hours;

    /**
     * The consultant property.
     */
    private Consultant consultant;

    /**
     * The constructor for the InvoiceLineItem class.
     * 
     * @param date       The date for the line item.
     * @param consultant The consultant for the line item.
     * @param skill      The skill for the line item.
     * @param hours      The hours for the line item.
     */
    public InvoiceLineItem(LocalDate date, Consultant consultant, Skill skill,
        int hours) {
        if (hours < 1) {
            throw new IllegalArgumentException("Hours cannot be less than 1!");
        }
        ;
        this.date = date;
        this.consultant = consultant;
        this.skill = skill;
        this.hours = hours;
    }

    /**
     * The getConsultant getter for the InvoiceLineItem class.
     * 
     * @return consultant The consultant for the line item.
     */
    public Consultant getConsultant() {
        return consultant;
    }

    /**
     * The getCharges method for the InvoiceLineItem class.
     * 
     * @return int The total charges for the individual line item.
     */
    public int getCharges() {
        int rate = skill.getRate();
        return hours * rate;
    }

    /**
     * The getDate getter for the InvoiceLineItem property.
     * 
     * @return date The date that the line item is for.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * The getHours method for the InvoiceLineItem class.
     * 
     * @return hours The hours for the individual line item.
     */
    public int getHours() {
        return hours;
    }

    /**
     * The getSkill method for the InvoiceLineItem class.
     * 
     * @return The skill being billed for in regards to the current line item.
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * The toString method for the line item.
     * 
     * @return String The human-readable string representing the contents of the
     *         InvoiceLineItem class.
     * 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDate()).append("  ").append(consultant)
            .append("              ").append(getSkill()).append("     ")
            .append(getHours()).append("      ").append(getCharges())
            .append("\n");
        return sb.toString();
    }
}
