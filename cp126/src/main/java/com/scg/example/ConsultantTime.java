package com.scg.example;

public final class ConsultantTime {

    ConsultantTime(java.time.LocalDate date, Account account, Skill skillType,
        int hours) {
    };

    public boolean equals(Object obj) {
        return true;
    };

    public Account getAccount() {
    };

    public java.time.LocalDate getDate() {
    };

    public int getHours() {
    };

//    Getter for hours property.
    public Skill getSkill() {
    };

//    Getter for skill property.
    public int hashCode() {
    };

    public boolean isBillable() {
        return true;
    };

//    Determines if the time is billable.
    public void setAccount(Account account) {
    };

//    Setter for account property.
    public void setDate(java.time.LocalDate date) {
    };

//    Setter for date property.
    public void setHours(int hours) {
    };

//    Setter for hours property.
    public String toString() {
        return "";
    };
//    Creates a string representation of the consultant time.

}
