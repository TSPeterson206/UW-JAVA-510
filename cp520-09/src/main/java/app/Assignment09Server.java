package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.cp520.scg.net.InvoiceServer;
import edu.uw.ext.util.ListFactory;

/**
 * The Assignment08Server class for the timecard/invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment09Server implements Serializable {

    /**
     * The main method for the Assignment08Server class.
     * 
     * @param args The arguments for the main method.
     * @throws Exception The exception thrown.
     */
    public static void main​(String[] args) throws Exception {

        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        InvoiceServer server = new InvoiceServer(10888, accounts, consultants,
            timeCards);
//        InvoiceServer.run(true, 10888);
        server.run(true, 10888);
    }
}
