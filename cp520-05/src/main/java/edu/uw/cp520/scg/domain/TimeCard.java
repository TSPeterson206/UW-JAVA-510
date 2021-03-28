package edu.uw.cp520.scg.domain;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The TimeCard class for the invoice project. This class contains the hours on
 * a timecard entry and the individual names of those being contracted as
 * consultants.
 * 
 * @author Toby Peterson.
 *
 */
public final class TimeCard
    implements Comparator<TimeCard>, java.io.Serializable {

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

    /**
     * The two-parameter constructor for the TimeCard class. It sets the
     * consultant name and starting day.
     * 
     * @param consultant      The consultant for which there is a timecard is
     *                        being generated.
     * @param weekStartingDay The starting day of the week for the selected
     *                        consultant.
     */
    public TimeCard(Consultant consultant,
        java.time.LocalDate weekStartingDay) {
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
//        List<ConsultantTime> billable = new ArrayList<ConsultantTime>();
//
//        for (ConsultantTime item : time) {
//            if (item.isBillable() == true
//                && item.getAccount().getName().equals(clientName)) {
//                billable.add(item);
//            }
//            ;
//        }
//        ;
//        return billable;

        List<ConsultantTime> billableHours = time.stream()
            .filter(hours -> hours.isBillable() == true
                && hours.getAccount().getName().equals(clientName))
            .collect(Collectors.toList());
        return billableHours;
    }

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
     * @return The collection of hours for the consultant.
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
        Formatter fm = new Formatter(sb, Locale.US);

        String formattedDate = startingDay
            .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));

        fm.format(
            "====================================================================")
            .format("%nConsultant: %-28s Week Starting: ", consultant.getName())
            .format(formattedDate).format("%nBillable Time:%n")
            .format("%-28s %-10s %6s %6s%n"
                + "---------------------------  ----------  -----  --------------------%n",
                "Account", "Date", "Hours", "Skill");

        for (ConsultantTime item : time) {
            if (item.isBillable()) {
                fm.format("%-28s %2$tm/%2$td/%2$tY %3$6d %4$17s%n",
                    item.getAccount().getName(), item.getDate(),
                    item.getHours(), item.getSkill());
            }
            ;
        }

        fm.format("%nNon-billable Time:%n").format("%-28s %-10s %6s %6s%n"
            + "---------------------------  ----------  -----  --------------------%n",
            "Account", "Date", "Hours", "Skill");

        for (ConsultantTime item : getConsultingHours()) {
            if (item.isBillable() == false) {
                fm.format("%-28s %2$tm/%2$td/%2$tY %3$6d %4$17s%n",
                    item.getAccount().getName(), item.getDate(),
                    item.getHours(), item.getSkill());
            }
            ;
        }

        fm.format("%nSummary:%n")
            .format("%-39s %5d%n", "Total Billable:", getTotalBillableHours())
            .format("%-39s %5d%n", "Total Non-Billable:",
                getTotalNonBillableHours())
            .format("%-39s %5d%n", "Total Hours:",
                getTotalBillableHours() + getTotalNonBillableHours())
            .format(
                "====================================================================");

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
        return String.format("TimeCard for: %s, Week Starting: %s",
            consultant.getName(), startingDay
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
//        return toReportString();
    }

    /**
     * The compare method for the TimeCard class.
     * 
     * @param arg0 The first TimeCard object for comparison.
     * @param arg1 The second TimeCard object for comparison.
     * @return The numerica value of the comparison between the two entered
     *         objects.
     * 
     */
    public int compare(TimeCard arg0, TimeCard arg1) {
        int cmp = arg0.getConsultant().getName().toString()
            .compareTo(arg1.getConsultant().getName().toString());

        if (cmp == 0) {
            cmp = arg0.getWeekStartingDay()
                .compareTo(arg1.getWeekStartingDay());
        }

        if (arg0.getTotalBillableHours() < arg1.getTotalBillableHours()) {
            return -1;
        } else if (arg0.getTotalNonBillableHours() > arg1
            .getTotalNonBillableHours()) {
            return 1;
        }
        return cmp;
        // TimeCard's natural ordering should be in ascending order
        // by beginning date, consultant, total billable hours and
        // finally total non-billable hours.
    };
}