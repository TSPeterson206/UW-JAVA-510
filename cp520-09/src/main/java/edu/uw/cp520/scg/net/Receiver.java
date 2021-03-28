package edu.uw.cp520.scg.net;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
public class Receiver implements Runnable {

    /**
     * The port property to be used.
     */
    public static final int port = 10888;

//    /**
//     * The accounts list property to be used.
//     */
//    public static List<ClientAccount> accounts = new ArrayList<>();
//
//    /**
//     * The consultants list property to be used,
//     */
//    public static List<Consultant> consultants = new ArrayList<>();
//
//    /**
//     * The timecards list property to be used,
//     */
//    public static List<TimeCard> timeCards = new ArrayList<>();
//
//    /**
//     * The connection/socket property to be used.
//     */
//    public static Socket connection;

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
    private String outputDirectory;

    /**
     * The hostName property.
     */
    private String hostName;

    /**
     * The main method for the class.
     * 
     * @param args The arguments supplied
     */

    public static void main(String[] args) {
//        Thread receiver1 = new Thread("receiver1");
//        Thread receiver2 = new Thread("receiver2");
//        Thread receiver3 = new Thread("receiver3");
//
//        receiver1.start();
//        receiver2.start();
//        receiver3.start();
    }

    /**
     * Constructor for the Receiver class.
     * 
     * @param connection     The socket connection.
     * @param clientList     The list of clients managed.
     * @param consultantList The list of consultants managed.
     * @param timecardList   The list of timecards managed.
     * @param server         The server being utilized.
     * @param hostName       The hostName
     */
    public Receiver(Socket connection, List<ClientAccount> clientList,
        List<Consultant> consultantList, List<TimeCard> timecardList,
        InvoiceServer server, String hostName) {
        this.connection = connection;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.server = server;
        this.timecardList = timecardList;
        this.hostName = hostName;
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
                Path path = Paths
                    .get("target/output-files/" + this.getOutputProperty());
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

    /**
     * The SetOutputDirectoryCommand method.
     * 
     * @param cmd The command to be executed.
     * @throws Exception The exception potentially thrown.
     */
    public void execute(SetOutputDirectoryCommand cmd) throws Exception {
        System.out
            .println("Do the setOutputDirectoryCommand action. Command type: "
                + cmd.getClass().getSimpleName());
        this.hostName = cmd.getTarget();
    }

    /**
     * The getOutputDirectory getter.
     * 
     * @return String The outputDirectory property.
     */
    public String getOutputProperty() {
        return this.outputDirectory;
    }

    public void setOutputProperty(String outputDirectory) {
        this.hostName = outputDirectory;
    }

    /**
     * The run method for the receiver.
     */
    @Override
    public void run() {
        setOutputProperty("id: " + this.hashCode());
        System.out.println("hitting receiver run method start: " + hostName);
//        try {
//            serverSocket = new ServerSocket(port);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }

//        while (!serverSocket.isClosed()) {
        while (!connection.isClosed()) {

//            try {
//                connection = serverSocket.accept();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
            System.out.println("Connection from " + connection + "!");

//            Receiver r = new Receiver(connection, accounts, consultants,
//                timeCards, server);
//
//            Thread t = new Thread(r);
//            t.start();

            try {
                InputStream inputStream = connection.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(
                    inputStream);

                List<Command> commands = null;
                try {
                    commands = (List<Command>) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                for (Command<?> cmd : commands) {
                    cmd.setReceiver(this);
                    cmd.execute();
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("hitting receiver run method end: " + hostName);

    }

    public String toString() {
        return this.hostName;
    }
}
