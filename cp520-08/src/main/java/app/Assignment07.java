package app;

import java.io.Console;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Invoice;
import edu.uw.ext.util.ListFactory;

/**
 * The Assignment 07 driver for the timecard/invoice project. It is used to grab
 * the clients and add them to a list of invoices for printing.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment07 {

    /**
     * The encoding string property for the printwriter.
     */
    private static final String ENCODING = "ISO-8859-1";

    /**
     * The main method for the Assignment07 class.
     * 
     * @param args The arguments being passed in.
     * @throws SQLException                 The exception thrown when a SQL
     *                                      query fails.
     * @throws UnsupportedEncodingException The exception thrown when
     *                                      unsupported coding is declared.
     */
    public static void main(String[] args)
        throws SQLException, UnsupportedEncodingException {

        Console console = System.console();

        PrintWriter consoleWrtr = (console != null) ? console.writer()
            : new PrintWriter(new OutputStreamWriter(System.out, ENCODING),
                true);

        DBServer dbs = new DBServer("jdbc:derby://localhost:1527/memory:scgDb",
            "student", "student");

        List<Invoice> invoices = new ArrayList<>();

        List<ClientAccount> clientList = dbs.getClients();

        for (ClientAccount client : clientList) {
            invoices.add(dbs.getInvoice​(client, Month.MARCH, 2017));
        }

        consoleWrtr.println();
        consoleWrtr.println(
            "==================================================================================");
        consoleWrtr.println(
            "=============================== I N V O I C E S ==================================");
        consoleWrtr.println(
            "==================================================================================");
        consoleWrtr.println();

        ListFactory.printInvoices(invoices, consoleWrtr);
    }
}
