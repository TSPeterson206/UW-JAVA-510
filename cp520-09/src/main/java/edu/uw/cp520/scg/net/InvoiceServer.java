package edu.uw.cp520.scg.net;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
     * The default port property;
     */
    public int DEFAULT_PORT = 0;

    /**
     * The accounts list property to be used.
     */
    public List<ClientAccount> accounts = new ArrayList<>();

    /**
     * The consultants list property to be used,
     */
    public List<Consultant> consultants = new ArrayList<>();

    /**
     * The timecards list property to be used,
     */
    public List<TimeCard> timeCards = new ArrayList<>();

    /**
     * The connection/socket property to be used.
     */
    public Socket connection;

    /**
     * The serverSocket property.
     */
    public ServerSocket serverSocket = null;

    /**
     * The directory property.
     */
    public String serverDirectory;

    /**
     * The counter property
     */
    private int counter = 0;

    /**
     * The constructor for the InvoiceServer class.
     * 
     * @param port        The port.
     * @param accounts    The accounts list.
     * @param consultants The consultants list.
     * @param directory   The directory.
     */
    public InvoiceServer(int port, List<ClientAccount> accounts,
        List<Consultant> consultants, String directory) {
        this.DEFAULT_PORT = port;
        this.accounts = accounts;
        this.consultants = consultants;
        this.serverDirectory = directory;
    }

    /**
     * The run method for the InvoiceServer class.
     * 
     * @throws IOException            The exception thrown for an IO issue.
     * @throws ClassNotFoundException The exception thrown for a class not being
     *                                found.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void run() throws IOException, ClassNotFoundException {
        System.out.println("%%% SERVER LISTENING %%");
        Runtime.getRuntime().addShutdownHook(
            new MyShutdownHook(accounts, consultants, serverDirectory));

        File directory = null;

        try (ServerSocket listener = new ServerSocket(DEFAULT_PORT);) {
            serverSocket = listener;

            while (!serverSocket.isClosed()) {
                try {
                    Socket client = serverSocket.accept();
                    counter++;
                    Receiver r = new Receiver(client, "Receiver#" + counter,
                        accounts, consultants, this);
                    directory = new File(serverDirectory,
                        Integer.toString(counter));
                    if (directory.exists() || directory.mkdirs()) {
                        r.setOutputDirectory(directory);
                        Thread thread = new Thread(r, "receiver" + counter);
                        thread.start();
                    } else {
                        System.out.println("this thread biffed it hard");
                    }
                    ;
                } catch (SocketException e) {
//                    e.printStackTrace();
                    break;
                } catch (IOException e) {
                    if (!serverSocket.isClosed()) {
                        System.out
                            .println("connection failed. Abandon all hope!");
                        try {
                            serverSocket.close();
                        } catch (IOException ex) {
                            System.out.println("There was an IOException!");
                        }
                    } else {
                        System.out.println(
                            "The shutdown command is shutting it all down");
                    }
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }

    /**
     * The shutDown method.
     * 
     * @throws IOException The exception thrown an IO issue.
     */
    public void shutdown() throws IOException {
        try {
//            connection.close();
            serverSocket.close();
        } catch (Exception e) {
        }
    }
}
