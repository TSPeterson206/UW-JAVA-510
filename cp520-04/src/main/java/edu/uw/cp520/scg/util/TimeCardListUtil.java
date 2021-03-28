package edu.uw.cp520.scg.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;

/**
 * The TimeCardUtilList utility class for the invoice/timecard project. It
 * contains a variety of methods to sort and filter lists of timecards.
 * 
 * @author Toby Peterson.
 *
 */
public class TimeCardListUtil {

    /**
     * The sortByStartDate method for TimeCardListUtil. It sorts this list into
     * ascending order, by the start date.
     * 
     * @param timeCards The list of timecards to be sorted.
     */
    public static void sortByStartDate(List<TimeCard> timeCards) {
        Collections.sort(timeCards, (p1, p2) -> p1.getWeekStartingDay()
            .compareTo(p2.getWeekStartingDay()));
    }

    /**
     * The sortByConsultantName method for the TimeCardListUtil class. It sorts
     * this list into ascending order by consultant name.
     * 
     * @param timeCards The list of timecards to be sorted.
     */
    public static void sortByConsultantName(List<TimeCard> timeCards) {
        Collections.sort(timeCards, (p1, p2) -> p1.getConsultant().getName()
            .toString().compareTo(p2.getConsultant().getName().toString()));
    }

    /**
     * The getTimeCardsForDateRanget class for the TimeCardListUtil class.
     * 
     * @param timeCards The timecards list passed to the method.
     * @param dateRange The daterange that the timecards are filtered by.
     * @return List The returned list of filtered TimeCard objects.
     */
    public static List<TimeCard> getTimeCardsForDateRange(
        List<TimeCard> timeCards, DateRange dateRange) {
        List<TimeCard> timeCardsInDateRange = timeCards.stream()
            .filter(tc -> dateRange.isInRange(tc.getWeekStartingDay()))
            .collect(Collectors.toList());
        return timeCardsInDateRange;

    }

    /**
     * The getTimeCardsForConsultant class for the TimeCardListUtil class.
     * 
     * @param timeCards  The timecards list passed to the method.
     * @param programmer The programmer that the timecards are filtered by.
     * @return List The returned list of filtered TimeCard objects.
     */
    public static List<TimeCard> getTimeCardsForConsultant(
        List<TimeCard> timeCards, Consultant programmer) {
        List<TimeCard> timeCardsForConsultant = timeCards.stream()
            .filter(tc -> tc.getConsultant() == programmer)
            .collect(Collectors.toList());
        return timeCardsForConsultant;
    }
}
