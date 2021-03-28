package edu.uw.cp520.scg.net;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.Invoice;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.ext.util.ListFactory;

/**
 * The Receiver class for the command pattern portion of the invoice/timecard
 * project. This class goes by CommandProcessor in some command pattern
 * implementations.
 * 
 * @author Toby Peterson.
 *
 */
public class Receiver {
    /**
     * The client list property.
     */
    private List<ClientAccount> clientList = new ArrayList<>();

    /**
     * The consultant list property.
     */
    private List<Consultant> consultantList = new ArrayList<>();

    /**
     * The timecard list property.
     */
    private List<TimeCard> timecardList = new ArrayList<>();

    /**
     * The server property to be used.
     */
    private InvoiceServer server;

    /**
     * The connection/socket property to be used.
     */
    private Socket connection;

    /**
     * Constructor for the Receiver class.
     * 
     * @param connection     The socket connection.
     * @param clientList     The list of clients managed.
     * @param consultantList The list of consultants managed.
     * @param timecardList   The list of timecards managed.
     * @param server         The server being utilized.
     */
    public Receiver(Socket connection, List<ClientAccount> clientList,
        List<Consultant> consultantList, List<TimeCard> timecardList,
        InvoiceServer server) {
        this.connection = connection;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.server = server;
        this.timecardList = timecardList;
    }

    /**
     * The execute command for AddClientCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(AddClientCommand cmd) {
        System.out.println("Do the addClientCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        clientList.add((ClientAccount) cmd.getTarget());
    }

    /**
     * The execute command for AddConsultantCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(AddConsultantCommand cmd) {
        System.out.println("Do the AddConsultantCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        consultantList.add((Consultant) cmd.getTarget());
    }

    /**
     * The execute command for CreateInvoicesCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(CreateInvoicesCommand cmd) {
        System.out.println("Do the CreateInvoicesCommand action. Command type: "
            + cmd.getClass().getSimpleName());

        List<Invoice> invoices = new ArrayList<>();
        String filename = null;
        String path1 = null;

        invoices = ListFactory.createInvoices(clientList, timecardList);
        for (Invoice invoice : invoices) {
            // CREATING FILES
            try {
                path1 = "src/main/resources/";
                filename = invoice.getClientAccount().getName().toString()
                    + "-March.txt";
                File myObj = new File(path1 + filename);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // WRITING TO FILES
            try {
                String holder = invoice.toReportString();
                PrintWriter fileWriter = new PrintWriter(path1 + filename,
                    "ISO-8859-1");
                fileWriter.write(holder);
                fileWriter.flush();
                fileWriter.close();
                System.out.println(
                    "Successfully wrote to the file. See target/output-files directory !!");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // CREATE DIRECTORY IN TARGET AND COPY OVER FILE
            try {
                Path path = Paths.get("target/output-files");
                Files.createDirectories(path);
                Path sourceDirectory = Paths.get(path1 + filename);
                Path targetDirectory = Paths
                    .get("target/output-files/" + filename);
                Files.copy(sourceDirectory, targetDirectory);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * The execute command for AddTimeCardCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(AddTimeCardCommand cmd) {
        System.out.println("Do the addTimeCardCommand action. Command type: "
            + cmd.getClass().getSimpleName());

        timecardList.add((TimeCard) cmd.getTarget());
    }

    /**
     * The execute command for DisconnectCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(DisconnectCommand cmd) {
        System.out.println("Do the disconnectCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        try {
            connection.shutdownOutput();
            connection.shutdownInput();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Closing sockets.");

    }

    /**
     * The execute command for ShutdownCommands.
     * 
     * @param cmd The command to be executed.
     * @throws Exception The exception thrown.
     */
    public void execute(ShutdownCommand cmd) throws Exception {
        System.out.println("Do the shutdownCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        server.shutdown();
    }
}
