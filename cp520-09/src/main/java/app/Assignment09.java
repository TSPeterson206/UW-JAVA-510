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
public class Assignment09 extends Thread implements Serializable {

    /**
     * The client1 property.
     */
    private static InvoiceClient client1;

    /**
     * The client2 property.
     */
    private static InvoiceClient client2;

    /**
     * The client3 property.
     */
    private static InvoiceClient client3;

    /**
     * The main method for the Assignment08 driver.
     * 
     * @param args The arguments passed in.
     * @throws IOException The exception thrown for an IO issue.
     */
    public static void main(String[] args) throws IOException {
//        client = new InvoiceClient();
//        client.run();
//        client.sendShutdown();

        client1 = new InvoiceClient("client1");
//        client1.start();
//
        client2 = new InvoiceClient("client2");
//        client2.start();
//
        client3 = new InvoiceClient("client3");
//        client3.start();

        Thread t = new Thread(client1);
        t.start();
        Thread t2 = new Thread(client2);
        t2.start();
        Thread t3 = new Thread(client3);
        t3.start();

    }
}