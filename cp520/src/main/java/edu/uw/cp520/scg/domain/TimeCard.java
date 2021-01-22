package edu.uw.cp520.scg.domain;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * The TimeCard class for the invoice project. This class contains the hours on
 * a timecard entry and the individual names of those being contracted as
 * consultants.
 * 
 * @author Toby Peterson.c
 *
 */
public final class TimeCard {

    /**
     * The time property for the TimeCard class. It is an arraylist of all time
     * logged for a given consultant.
     */
    private List<ConsultantTime> time = new ArrayList<ConsultantTime>();

    /**
     * The consultant property for the TimeCard class. It is the individual
     * identified as the consultant for which there is a timecard being
     * generated.
     */
    private Consultant consultant;

    /**
     * The startingDay property for the TimeCard class. It is the starting date
     * for the listed consultant.
     */
    private java.time.LocalDate startingDay;

    private String HEADER_FORMAT = "Consultant: %-28s Week Starting: %2$tb";

    private String TO_STRING_FORMAT = "TIMECard for: %s, Week Starting: %2$tb";

    private String LINE_HEADER_FORMAT = String.format("%28s %-10s %5s %s%n"
        + "----------------------------------- ----------- ------- -----------------------%n",
        "Account", "Date", "Hours", "Skill");

    private String CARD_BORDER = "===============================================================";

    private String LINE_FORMAT = "%-28s %2$tm/%2$td/%2$tY %3$5d %4$s%n";

    private String SUMMARY_LINE_FORMAT = "%-39s %5d%n";

    private String BILLABLE_TIME_HEADER_FORMAT = "%nBillable Time:%n";

    private String NON_BILLABLE_TIME_HEADER_FORMAT = "%nNon-billable Time:%n";

    private String SUMMARY_HEADER_FORMAT = "%nSummary:%n";

    /**
     * The two-parameter constructor for the TimeCard class. It sets the
     * consultant name and starting day.
     * 
     * @param consultant      The consultant for which there is a timecard is
     *                        being generated.
     * @param weekStartingDay The starting day of the week for the selected
     *                        consultant.
     */
    TimeCard(Consultant consultant, java.time.LocalDate weekStartingDay) {
        this.consultant = consultant;
        this.startingDay = weekStartingDay;
    };

    /**
     * The addConsultantTime method for the TimeCard class. It is used to add
     * entries to the hours for the selected consultant.
     * 
     * @param consultantTime The individual time entry to add to the collection
     *                       of time billed for the consultant.
     */
    public void addConsultantTime(ConsultantTime consultantTime) {
        time.add(consultantTime);
    };

    /**
     * The getBillableHoursForClient method for the TimeCard class. It is used
     * to specifically get the billable hours from the collection of hours
     * maintained by this timecard.
     * 
     * @param clientName The string-formatted name of the client for this this
     *                   method is getting the billable hours.
     * @return List<ConsultantTime> The billable hours for the specified client.
     */
    public List<ConsultantTime> getBillableHoursForClient(String clientName) {
        List<ConsultantTime> billable = new ArrayList<ConsultantTime>();

        for (ConsultantTime item : time) {
            if (item.isBillable() == true
                && item.getAccount().getName() == clientName) {
                billable.add(item);
            }
            ;
        }
        ;
        return billable;
    };

    /**
     * The getTotalNonBillableHours method for the TimeCard class. This is the
     * total value of non-billable hours.
     * 
     * @return int The total amount of non-billable hours.
     */
    public int getTotalNonBillableHours() {
        int nonBillableTime = 0;
        for (ConsultantTime item : time) {
            if (item.isBillable() == false) {
                nonBillableTime += item.getHours();
            }
            ;
        }
        ;
        return nonBillableTime;
    };

    /**
     * The getter for the consultant being managed within this TimeCard.
     * 
     * @return Consultant The value of the consultant property.
     */
    public Consultant getConsultant() {
        return this.consultant;
    };

    /**
     * The getter for the consultingHours property. It returns an arraylist of
     * all the logged hours.
     * 
     * @return List<ConsultantTime> The collection of hours for the consultant.
     */
    public List<ConsultantTime> getConsultingHours() {
        return time;
    };

    /**
     * The getTotalBillableHours method for the TimeCard class. It returns an
     * integer that is the total amount of billable hours.
     * 
     * @return int The total billable hours.
     */
    public int getTotalBillableHours() {
        int billableTime = 0;
        for (ConsultantTime item : time) {
            if (item.isBillable() == true) {
                billableTime += item.getHours();
            }
            ;
        }
        ;
        return billableTime;
    };

    /**
     * The getter for the total hours.
     * 
     * @return int The total hours maintained by the collection of hours within
     *         this TimeCard instance.
     */
    public int getTotalHours() {
        int totalHours = 0;
        for (ConsultantTime item : time) {
            totalHours += item.getHours();
        }
        return totalHours;
    };

    /**
     * The getWeekStartingDay method for the TimeCard class.
     * 
     * @return java.time.LocalDate The starting day of the week for the billing
     *         cycle noted on the timecard.
     */
    public java.time.LocalDate getWeekStartingDay() {
        return this.startingDay;
    };

    /**
     * The toReportString method for the TimeCard class. It is used to create a
     * string representation of this object, suitable for printing the entire
     * time card.
     * 
     * @return String A human-readable string that represents a timecard.
     */
    public String toReportString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("test to report string");
//        return sb.toString();
        Formatter fm = new Formatter(sb, Locale.US);

        fm.format(CARD_BORDER)
            .format(HEADER_FORMAT, consultant.getName(), startingDay)
            .format(BILLABLE_TIME_HEADER_FORMAT).format(LINE_HEADER_FORMAT);

//        appendTime(fm, getconsultingHours, true);
//        appendTime(fm, getTotalHours(), true);

        fm.format(NON_BILLABLE_TIME_HEADER_FORMAT).format(LINE_HEADER_FORMAT);

//        appendTime(fm, consultingHours, false);

        fm.format(SUMMARY_HEADER_FORMAT)
            .format(SUMMARY_LINE_FORMAT, "Total Billable:",
                getTotalBillableHours())
            .format(SUMMARY_LINE_FORMAT, "Total Non-Billable:",
                getTotalNonBillableHours())
            .format(SUMMARY_LINE_FORMAT, "Total Hours:",
                getTotalBillableHours() + getTotalNonBillableHours())
            .format(CARD_BORDER);

        String output = fm.toString();
        fm.close();
        return output;

    };

    /**
     * The toString method for the TimeCard class.
     * 
     * @return String The string representation of the TimeCard instance.
     */
    public String toString() {
        return String.format(TO_STRING_FORMAT, consultant.getName(), Locale.US);
    };
}

//====================================================================
//Consultant: Coder, Carl NMN              Week Starting: Feb 27, 2017
//
//Billable Time:
//Account                      Date        Hours  Skill
//---------------------------  ----------  -----  --------------------
//Acme Industries              02/27/2017      8  Software Engineer
//Acme Industries              02/28/2017      8  Software Engineer
//FooBar Enterprises           03/01/2017      8  Software Engineer
//FooBar Enterprises           03/02/2017      8  Software Engineer
//FooBar Enterprises           03/03/2017      8  Software Engineer
//
//Non-billable Time:
//Account                      Date        Hours  Skill
//---------------------------  ----------  -----  --------------------
//
//Summary:
//Total Billable:                             40
//Total Non-Billable:                          0
//Total Hours:                                40
//====================================================================
