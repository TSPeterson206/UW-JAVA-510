package edu.uw.cp520.example;

import edu.uw.cp520.scg.domain.Account;
import edu.uw.cp520.scg.domain.ConsultantTime;
import edu.uw.cp520.scg.domain.Skill;

/**
 * The ConsultantTime class for the invoice project. It encapsulates the time of
 * services accrued for record for a given account.
 * 
 * @author Toby Peterson.
 *
 */
public final class ConsultantTime {

    private Skill skill;
    private int hours;
    private Account account;
    private java.time.LocalDate date;

    ConsultantTime(java.time.LocalDate date, Account account, Skill skillType,
        int hours) {

        this.skill = skillType;
        setHours(hours);
        setAccount(account);
        setDate(date);
    };

    /**
     * The getter for the account property.
     * 
     * @return Account The account for which the logged time is being attributed
     *         to.
     */
    public Account getAccount() {
        return this.account;
    };

    /**
     * The equals method for the ConsultantTime class.
     * 
     * @param obj The ConsultantTime obj passed in as a parameter for
     *            comparison.
     * @return boolean The boolean value indicating whether or not this object
     *         and another object (passed as parameter) are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConsultantTime other = (ConsultantTime) obj;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (hours != other.hours)
            return false;
        if (skill != other.skill)
            return false;
        return true;
    }

    /**
     * The getter for the date property.
     * 
     * @return java.time.LocalDate The date for which the time is being logged.
     */
    public java.time.LocalDate getDate() {
        return this.date;
    };

    /**
     * The getter for the hours property.
     * 
     * @return int The integer value for the hours being logged.
     */
    public int getHours() {
        return this.hours;
    };

    /**
     * The getter for the skill property.
     * 
     * @return Skill The skill being billed for,
     */
    public Skill getSkill() {
        return this.skill;
    };

    /**
     * The hashCode method for the ConsultantTime class.
     * 
     * @return int The hashed value as an integer.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + hours;
        result = prime * result + ((skill == null) ? 0 : skill.hashCode());
        return result;
    };

    /**
     * The isBillable property for the ConsultantTime class.
     * 
     * @return boolean A boolean value indicating whether this time is billable
     *         to the account or not.
     */
    public boolean isBillable() {
        return true;
    };

    /**
     * The setter for the account property.
     * 
     * @param account The account for this ConsultantTime class to bill to.
     */
    public void setAccount(Account account) {
        this.account = account;
    };

    /**
     * The setter for the date property.
     * 
     * @param date The date for this ConsultantTime class to bill the hours for,
     */
    public void setDate(java.time.LocalDate date) {
        this.date = date;
    };

    /**
     * The setter for the hours property.
     * 
     * @param hours The hours for this ConsultantTime class to bill for.
     */
    public void setHours(int hours) {
        this.hours = hours;
    };

    /**
     * The toString method for the ConsultantTime class.
     * 
     * @return String The string representing the billed consultant time
     *         encapsulated within this object.
     */
    public String toString() {
        return "";
    };
}
