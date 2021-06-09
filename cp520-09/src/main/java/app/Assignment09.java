package app;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.cp520.scg.net.InvoiceClient;
import edu.uw.ext.util.ListFactory;

/**
 * The Assignment09 driver for the command pattern portion of the
 * invoice/timcard project. It instantiates a client.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment09 extends Thread implements Serializable {

    /**
     * The main method for the Assignment08 driver.
     * 
     * @param args The arguments passed in.
     * @throws IOException The exception thrown for an IO issue.
     * @throws Exception   The possible exception thrown.
     */
    public static void main(String[] args) throws IOException, Exception {
        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        final List<TimeCard> rockSolidTimeCards = Collections
            .unmodifiableList(timeCards);

        final InvoiceClient client1 = new InvoiceClient("client1",
            rockSolidTimeCards);
        final InvoiceClient client2 = new InvoiceClient("client2",
            rockSolidTimeCards);
        final InvoiceClient client3 = new InvoiceClient("client3",
            rockSolidTimeCards);

        client1.start();
        client2.start();
        client3.start();

        client1.join();
        client2.join();
        client3.join();

        client1.sendShutdown();
//        client2.sendShutdown();
//        client3.sendShutdown();

    }
}