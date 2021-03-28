package edu.uw.cp520.scg.domain;

import java.util.Objects;

/**
 * The ConsultantTime class for the invoice project. It encapsulates the time of
 * services accrued for record for a given account.
 * 
 * @author Toby Peterson.
 *
 */
public final class ConsultantTime {

    /**
     * The skill property for the ConsultantTime class.
     */
    private Skill skill;

    /**
     * The hours property for the ConsultantTime class.
     */
    private int hours;

    /**
     * The account property for the ConsultantTime class.
     */
    private Account account;

    /**
     * 
     */
    private java.time.LocalDate date;

    /**
     * The constructor for consultant time.
     * 
     * @param date      The date on which the skills were performed.
     * @param account   The account for which the skills were performed.
     * @param skillType The type of skill that the consultant posseses.
     * @param hours     The amount of hours performed for the consultant on the
     *                  specified date.
     */
    public ConsultantTime(java.time.LocalDate date, Account account,
        Skill skillType, int hours) {
        if (hours < 1) {
            throw new IllegalArgumentException(
                "What?! It's gotta be at least an hour or more!");
        }
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
     * The getter for the date property.
     * 
     * @return java.time.LocalDate The date for which the time is being logged.
     */
    public java.time.LocalDate getDate() {
        return this.date;
    };

    /**
     * The hashCode method for the ConsultantTime class.
     * 
     * @return int The hashed value as an integer.
     */
    @Override
    public int hashCode() {
        return Objects.hash(account, date, hours, skill);
    }

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
        if (!(obj instanceof ConsultantTime))
            return false;
        ConsultantTime other = (ConsultantTime) obj;
        return Objects.equals(account, other.account)
            && Objects.equals(date, other.date) && hours == other.hours
            && skill == other.skill;
    }

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
     * The isBillable property for the ConsultantTime class.
     * 
     * @return boolean A boolean value indicating whether this time is billable
     *         to the account or not.
     */
    public boolean isBillable() {
        if (account.isBillable() == true) {
            return true;
        } else {
            return false;
        }

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
        if (hours < 1) {
            throw new IllegalArgumentException(
                "What?! It's gotta be at least an hour or more!");
        }
        this.hours = hours;
    };

    /**
     * The toString method for the ConsultantTime class.
     * 
     * @return String The string representing the billed consultant time
     *         encapsulated within this object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConsultantTime: ").append(getAccount().getName())
            .append(", ").append(getDate()).append(", ").append(getHours())
            .append(", ").append(getSkill());
        return sb.toString();
    };
}
