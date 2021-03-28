package app;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.ext.util.ListFactory;

/**
 * The InitDb class for the timecard/invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class InitDb {

    /**
     * The dbs/database server property.
     */
    private static DBServer dbs = new DBServer(
        "jdbc:derby://localhost:1527/memory:scgDb", "student", "student");

    /**
     * The main method for the InitDb class.
     * 
     * @param args The arguments being passed in.
     * @throws SQLException                 The exception thrown when a SQL
     *                                      query fails.
     * @throws UnsupportedEncodingException The exception thrown when a declared
     *                                      encoding fails.
     */
    public static void main(String args[])
        throws SQLException, UnsupportedEncodingException {

        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        for (ClientAccount account : accounts) {
            dbs.addClient​(account);
        }

        for (Consultant consultant : consultants) {
            dbs.addConsultant​(consultant);
        }

        for (TimeCard timecard : timeCards) {
            dbs.addTimeCard​(timecard);
        }
    }
}
