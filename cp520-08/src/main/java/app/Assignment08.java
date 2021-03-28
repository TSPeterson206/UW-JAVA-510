package app;

import java.io.IOException;
import java.io.Serializable;

import edu.uw.cp520.scg.net.InvoiceClient;

/**
 * The Assignment08 driver for the command pattern portion of the
 * invoice/timcard project. It instantiates a client.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment08 implements Serializable {

    /**
     * The client property.
     */
    private static InvoiceClient client;

    /**
     * The main method for the Assignment08 driver.
     * 
     * @param args The arguments passed in.
     * @throws IOException The exception thrown for an IO issue.
     */
    public static void main(String[] args) throws IOException {
        client = new InvoiceClient();
        client.run();
        client.sendShutdown();
    }
}
