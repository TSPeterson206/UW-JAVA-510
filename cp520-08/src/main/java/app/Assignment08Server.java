package app;

import java.io.Serializable;

import edu.uw.cp520.scg.net.InvoiceServer;

/**
 * The Assignment08Server class for the timecard/invoice project.
 * 
 * @author Toby Peterson.
 *
 */
public class Assignment08Server implements Serializable {

    /**
     * The main method for the Assignment08Server class.
     * 
     * @param args The arguments for the main method.
     * @throws Exception The exception thrown.
     */
    public static void main​(String[] args) throws Exception {
        InvoiceServer.run(true, 10888);
    }
}
