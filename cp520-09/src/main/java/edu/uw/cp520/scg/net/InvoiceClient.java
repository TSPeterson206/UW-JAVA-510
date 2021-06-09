package edu.uw.cp520.scg.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.cp520.scg.util.Address;
import edu.uw.cp520.scg.util.PersonalName;
import edu.uw.cp520.scg.util.StateCode;

/**
 * The InvoiceClient class for the command pattern portion of the
 * invoice/timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceClient extends Thread implements Serializable {

    /**
     * The port property to be used.
     */
    private static int DEFAULT_PORT = 10888;

    /**
     * The hostName property.
     */
    private String hostName;

    /**
     * The accounts list property.
     */
    final List<ClientAccount> accounts = new ArrayList<>();

    /**
     * The consultants list property.
     */
    final List<Consultant> consultants = new ArrayList<>();

    /**
     * The timecards list property.
     */
    private List<TimeCard> timeCards = new ArrayList<>();

    /**
     * The commands list property.
     */
    @SuppressWarnings("rawtypes")
    private static List<Command> commands = new ArrayList<>();

    /**
     * The socket to be used.
     */
    private Socket socket = null;

    /**
     * The outputStream property.
     */
    private OutputStream outputStream;

    /**
     * The objectOutputStream prooperty.
     */
    private ObjectOutputStream objectOutputStream;

    /**
     * The threadName property.
     */
    private String threadName;

    /**
     * The constructor for the InvoiceClient class.
     * 
     * @param threadName The name of the thread.
     * @param timeCards  The timeCard list.
     */
    public InvoiceClient(String threadName, List<TimeCard> timeCards) {
        this.timeCards = timeCards;
        this.threadName = threadName;
    };

    /**
     * The run method for the InvoiceClient class. It runs the server.
     */
    @Override
    public void run() {
        try {
            setHostName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try (Socket socket = new Socket(hostName, DEFAULT_PORT);) {
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            sendConsultants();
            sendClients();
            sendTimeCards();
            sendInvoices();
            sendDisconnect();
            sendShutdown();

//            sendShutdown();
//            socket.shutdownOutput();

            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * The sendClients method.
     */
    public void sendClients() {
        Address address1 = new Address("123 main st", "seattle", StateCode.WA,
            "98116");
        Address address2 = new Address("456 broadway ave", "stockton",
            StateCode.CA, "98116");
        PersonalName contact1 = new PersonalName("Gates", "William", "Marion");
        PersonalName contact2 = new PersonalName("Allen", "Paul", "Francis");
        ClientAccount account1 = new ClientAccount("Acme Industries", contact1,
            address1);
        ClientAccount account2 = new ClientAccount("FooBar Enterprises",
            contact2, address2);

        Command<?> client = new AddClientCommand(account1);
        Command<?> client2 = new AddClientCommand(account2);

        try {
            objectOutputStream.writeObject(client);
            objectOutputStream.flush();
            objectOutputStream.writeObject(client2);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    };

    /**
     * The sendConsultants method.
     */
    public void sendConsultants() {
        PersonalName name = new PersonalName("Thoreau", "Henry", "David");
        Consultant consultantSample = new Consultant(name);
        Command<?> consultant = new AddConsultantCommand(consultantSample);

        PersonalName name2 = new PersonalName("Wallace", "David", "Foster");
        Consultant consultantSample2 = new Consultant(name2);
        Command<?> consultant2 = new AddConsultantCommand(consultantSample2);

        try {
            objectOutputStream.writeObject(consultant);
            objectOutputStream.flush();

            objectOutputStream.writeObject(consultant2);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    };

    /**
     * The sendTimeCards method.
     */
    public void sendTimeCards() {
        for (TimeCard tc : timeCards) {
            Command<?> timeCardCommand = new AddTimeCardCommand(tc);
            try {
                objectOutputStream.writeObject(timeCardCommand);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * The sendInvoices method.
     */
    public void sendInvoices() {
        Command<?> invoices = new CreateInvoicesCommand(
            LocalDate.of(2017, 03, 01));
        try {
            objectOutputStream.writeObject(invoices);
            objectOutputStream.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * The sendDisconnect method.
     * 
     * @throws UnknownHostException The exception thrown if a host is unknown.
     * @throws IOException          The exception thrown if an IO issue occurs.
     */
    public void sendDisconnect() throws IOException {
        Command<?> disconnect = new DisconnectCommand();
        try {
            objectOutputStream.writeObject(disconnect);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        server.close();

        System.out.println("Closing socket and terminating program.");
    }

    /**
     * The sendShutdown method.
     * 
     * @throws UnknownHostException The exception thrown if a host is unknown.
     * @throws IOException          The exception thrown if an IO issue occurs.
     */
    public void sendShutdown() throws UnknownHostException, IOException {
        try (Socket server = new Socket(hostName, DEFAULT_PORT);) {

            ObjectOutputStream out = new ObjectOutputStream(
                server.getOutputStream());
            Command<?> shutdown = new ShutdownCommand();
            try {
//                objectOutputStream.writeObject(shutdown);
//                objectOutputStream.flush();
                server.shutdownInput();
                out.writeObject(shutdown);
                out.flush();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The getHostName getter method.
     * 
     * @return The hostname string.
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * The setHostName setter.
     * 
     * @param hostName The hostName to be set.
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * The getThreadName getter.
     * 
     * @return String The threadName property.
     */
    public String getThreadName() {
        return this.threadName;
    }
}
