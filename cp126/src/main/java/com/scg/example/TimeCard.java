package com.scg.example;

import java.util.List;

public final class TimeCard {

    TimeCard(Consultant consultant, java.time.LocalDate weekStartingDay) {
    };

    public void addConsultantTime(ConsultantTime consultantTime) {
    };

//    Add a ConsultantTime object to the collection maintained by this TimeCard.
    public List<ConsultantTime> getBillableHoursForClient(String clientName) {
    };

//    Returns the billable hours (if any) in this TimeCard for the specified Client.
    public Consultant getConsultant() {
    };

//    Getter for consultant property.
    public List<ConsultantTime> getConsultingHours() {
    };

//    Getter for consultingHours property.
    public int getTotalBillableHours() {
    };

//    Getter for billableHours property.
    public int getTotalHours() {
    };

//    Getter for totalHours property.
    public int getTotalNonBillableHours() {
    };

//    Getter for totalNonBillableHours property.
    public java.time.LocalDate getWeekStartingDay() {
    };

//    Getter for weekStartingDay property.
    public String toReportString() {
    };

//    Create a string representation of this object, suitable for printing the entire time card.
    public String toString() {
    };
}
