package edu.uw.cp520.scg.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The DateRange utility class for the invoice/timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class DateRange {

    /**
     * The dates property. This is a list of LocalDates that will hold all of
     * the dates in the specified range.
     */
    private List<LocalDate> dates = new ArrayList<LocalDate>();

    /**
     * The startDate property.
     */
    private LocalDate startDate;

    /**
     * The endDate property.
     */
    private LocalDate endDate;

    /**
     * The two-parameter(string) constructor for the DateRange utility class.
     * 
     * @param start The start date for the DateRange class.
     * @param end   The end date for the DateRange class.
     */
    public DateRange(String start, String end) {

        this.startDate = LocalDate.parse(start);
        this.endDate = LocalDate.parse(end);

        dates = startDate.datesUntil(endDate).collect(Collectors.toList());
    }

//    Construct a DateRange given two date strings in the correct format.
    /**
     * The two-parameter(LocalDates) constructor for the DateRange class.
     * 
     * @param startDate The start date for the DateRange class.
     * @param endDate   The end date for the DateRange class.
     */
    public DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

        dates = startDate.datesUntil(endDate).collect(Collectors.toList());
    }

    /**
     * The two-parameter (month, year) constructor for the DateRange class. The
     * date range shall span the entire month, from the first day of the month
     * through the last day of the month.
     * 
     * @param month The month to be used for the range.
     * @param year  The year to be used for the range.
     */
    public DateRange(Month month, int year) {
        startDate = LocalDate.of(year, month.getValue(), 1);
        LocalDate end = startDate.withDayOfMonth(startDate.lengthOfMonth());

        endDate = end;

        dates = startDate.datesUntil(endDate).collect(Collectors.toList());
    }

    /**
     * The getEndDate method for the DateRange class.
     * 
     * @return endDate The endDate property.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * The getStartDate method for the DateRange class.
     * 
     * @return startDate The endDate property.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * The isInRange method for the DateRange class. It returns true if the
     * specified date is within the range start date <= date <= end date.
     * 
     * @param date The date to be checked for.
     * @return boolean The boolean value determinging if the passed date is in
     *         the range or not.
     */
    public boolean isInRange(LocalDate date) {
        if (dates.contains(date)) {
            return true;
        } else {
            return false;
        }
    }
}
