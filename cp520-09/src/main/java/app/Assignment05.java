package app;

import java.io.Console;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.Invoice;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.ext.util.ListFactory;

/**
 * The Assignment05 driver class for the serialization portion of the
 * Invoice/TimeCard class.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment05 {

    private static final String ENCODING = "ISO-8859-1";

    private static final Logger log = LoggerFactory
        .getLogger(Assignment05.class);

    /**
     * The main method for the Assignment05 class.
     * 
     * @param args The arguments being used for the main method.
     * @throws UnsupportedEncodingException An exception of the encoding is
     *                                      unsupported.
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("hitting Assignment05");

        Console console = System.console();

        @SuppressWarnings("resource") // don't want to close console or
        // System.out
        PrintWriter consoleWrtr = (console != null) ? console.writer()
            : new PrintWriter(new OutputStreamWriter(System.out, ENCODING),
                true);

        List<TimeCard> timecards = null;

        try {
            FileInputStream fileIn1 = new FileInputStream(
                "resources/TimeCardList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn1);
            timecards = (List<TimeCard>) in.readObject();
            in.close();
            fileIn1.close();
        } catch (EOFException e) {
            System.out.println("hitting EOF Exception");
            e.printStackTrace();
            return;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        List<ClientAccount> accounts = null;
        List<Consultant> consultants = null;

        try {
            FileInputStream fileIn2 = new FileInputStream(
                "resources/ClientList.ser");
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            accounts = (List<ClientAccount>) in2.readObject();
            consultants = (List<Consultant>) in2.readObject();
            in2.close();
            fileIn2.close();
        } catch (EOFException e) {
            System.out.println("hitting EOF Exception");
            e.printStackTrace();
            return;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        consoleWrtr.println();
        consoleWrtr.println(
            "==================================================================================");
        consoleWrtr.println(
            "=============================== I N V O I C E S ==================================");
        consoleWrtr.println(
            "==================================================================================");
        consoleWrtr.println();

        // Create invoices using deserialized info from both files
        final List<Invoice> invoices = ListFactory.createInvoices(accounts,
            timecards);
        // Print invoices
        ListFactory.printInvoices(invoices, consoleWrtr);
        log.info("These are the deserialized consultants: " + consultants);
    }
}