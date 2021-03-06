package edu.uw.cp520.scg.net;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import app.MyShutdownHook;
import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;

/**
 * The InvoiceServer class for the command pattern portion of the
 * invoice/timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceServer {

    /**
     * The port property to be used.
     */
    public static final int DEFAULT_PORT = 10888;

    /**
     * The accounts list property to be used.
     */
    public static List<ClientAccount> accounts = new ArrayList<>();

    /**
     * The consultants list property to be used,
     */
    public static List<Consultant> consultants = new ArrayList<>();

    /**
     * The timecards list property to be used,
     */
    public static List<TimeCard> timeCards = new ArrayList<>();

    /**
     * The connection/socket property to be used.
     */
    public static Socket connection;

    /**
     * The serverSocket property.
     */
    public static ServerSocket serverSocket = null;

    /**
     * The constructor for the InvoiceServer class.
     */
    public InvoiceServer() {
    }

    /**
     * The run method for the InvoiceServer class.
     * 
     * @param bool The toggler property.
     * @param port The port to run on.
     * @throws IOException            The exception thrown for an IO issue.
     * @throws ClassNotFoundException The exception thrown for a class not being
     *                                found.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void run(boolean bool, int port)
        throws IOException, ClassNotFoundException {
        System.out.println("%%% SERVER LISTENING %%");

        InvoiceServer server = new InvoiceServer();
        Runtime.getRuntime().addShutdownHook(new MyShutdownHook());

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        while (!serverSocket.isClosed()) {

            try {
                connection = serverSocket.accept();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("Connection from " + connection + "!");
            Receiver r = new Receiver(connection, accounts, consultants,
                timeCards, server);

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
                    cmd.setReceiver(r);
                    cmd.execute();
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The shutDown method.
     * 
     * @throws IOException The exception thrown an IO issue.
     */
    public void shutdown() throws IOException {
        try {
            connection.close();
            serverSocket.close();
        } catch (Exception e) {
        }
    }
}
