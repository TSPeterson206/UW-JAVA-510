package edu.uw.cp520.scg.util;

import java.util.Comparator;

import edu.uw.cp520.scg.domain.TimeCard;

/**
 * The TimeCardConsultantComparator class for the invoice/timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class TimeCardConsultantComparator implements Comparator<TimeCard> {

    /**
     * The compare method for TimeCardConsultantComparator.
     * 
     * @param arg0 The first TimeCard object for comparison.
     * @param arg1 The second TimeCard object for comparison.
     * @return int The integer value determining whether or not the two TimeCard
     *         objects are equal.
     */
    @Override
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
    }
}