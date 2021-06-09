package edu.uw.cp520.scg.net;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Receiver implements Runnable {

    /**
     * The port property to be used.
     */
    public static final int port = 10888;

    /**
     * The serverSocket property.
     */
    public static ServerSocket serverSocket = null;
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
     * The outputDirectory property.
     */
    private File outputDirectory;

    /**
     * The inputStream property.
     */
    private ObjectInputStream inputStream;

    /**
     * The name property.
     */
    private String name;

//    public static void main(String[] args) {
////        Thread receiver1 = new Thread("receiver1");
////        Thread receiver2 = new Thread("receiver2");
////        Thread receiver3 = new Thread("receiver3");
////
////        receiver1.start();
////        receiver2.start();
////        receiver3.start();
//    }

    /**
     * Constructor for the Receiver class.
     * 
     * @param connection     The socket connection.
     * @param name           The output directory name.
     * @param clientList     The list of clients managed.
     * @param consultantList The list of consultants managed.
     * @param server         The server being utilized.
     */
    public Receiver(Socket connection, String name,
        List<ClientAccount> clientList, List<Consultant> consultantList,
        InvoiceServer server) {
        this.connection = connection;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.server = server;
        this.name = name;
    }

    /**
     * The execute command for AddClientCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(AddClientCommand cmd) {
        System.out.println("Do the addClientCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        synchronized (clientList) {
            if (!clientList.contains(cmd.getTarget())) {
                clientList.add((ClientAccount) cmd.getTarget());
            }
        }
    }

    /**
     * The execute command for AddConsultantCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(AddConsultantCommand cmd) {
        System.out.println("Do the AddConsultantCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        synchronized (consultantList) {
            if (!consultantList.contains(cmd.getTarget())) {
                consultantList.add((Consultant) cmd.getTarget());
            }
        }
    }

    /**
     * The execute command for CreateInvoicesCommands.
     * 
     * @param cmd The command to be executed.
     */
    public void execute(CreateInvoicesCommand cmd) {
        System.out.println("Do the CreateInvoicesCommand action. Command type: "
            + cmd.getClass().getSimpleName() + " " + name);

        List<Invoice> invoices = new ArrayList<>();
        String filename = null;
        String path1 = null;

        invoices = ListFactory.createInvoices(clientList, timecardList);
        for (Invoice invoice : invoices) {
            try {
                filename = invoice.getClientAccount().getName().toString()
                    + "-March.txt";
                File myObj = new File(outputDirectory, filename);

                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }

                String holder = invoice.toReportString();
                PrintWriter fileWriter = new PrintWriter(myObj, "ISO-8859-1");
                fileWriter.write(holder);
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Successfully wrote to the file. See "
                    + outputDirectory + " directory !!");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
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
     * @throws IOException
     */
    public void execute(DisconnectCommand cmd) throws IOException {
        System.out.println("Do the disconnectCommand action. Command type: "
            + cmd.getClass().getSimpleName());
        try {
//            connection.shutdownOutput();
//            connection.shutdownInput();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Closing sockets.");
        server.shutdown();

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
        try {
            connection.close();
        } catch (final IOException e) {
            System.out.println("Shutdown unable to close client connection.");
        } finally {
            server.shutdown();
        }
    }

    /**
     * The getOutputDirectory getter.
     * 
     * @return String The outputDirectory property.
     */
    public File getOutputProperty() {
        return this.outputDirectory;
    }

    /**
     * The run method for the receiver.
     */
    @Override
    public void run() {
        try {
            inputStream = new ObjectInputStream(connection.getInputStream());
//            connection.shutdownOutput();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            while (!connection.isClosed()) {
                Object object = inputStream.readObject();
                Command<?> command = (Command<?>) object;
                command.setReceiver(this);
                command.execute();
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ;
    }

    public void setOutputDirectory(File directory) {
        this.outputDirectory = directory;

    }
}
