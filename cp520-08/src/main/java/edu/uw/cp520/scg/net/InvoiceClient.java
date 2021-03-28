package edu.uw.cp520.scg.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
import edu.uw.ext.util.ListFactory;

/**
 * The InvoiceClient class for the command pattern portion of the
 * invoice/timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class InvoiceClient {

    /**
     * The port property to be used.
     */
    private static int DEFAULT_PORT = 10888;

    /**
     * The hostName property.
     */
    private static String hostName;

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
    final List<TimeCard> timeCards = new ArrayList<>();

    /**
     * The commands list property.
     */
    @SuppressWarnings("rawtypes")
    private List<Command> commands = new ArrayList<>();

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
     * The constructor for the InvoiceClient class.
     */
    public InvoiceClient() {
    };

    /**
     * The run method for the InvoiceClient class. It runs the server.
     * 
     * @throws IOException The exception thrown when an IO issue occurs.
     */
    public void run() throws IOException {
        setHostName(InetAddress.getLocalHost().getHostName());
        ListFactory.populateLists(accounts, consultants, timeCards);

        socket = new Socket(hostName, DEFAULT_PORT);
        System.out.println("Connected? " + socket.isBound());
        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);

        sendConsultants();
        sendClients();
        sendTimeCards();
        sendInvoices();
        sendDisconnect();

        objectOutputStream.writeObject(commands);
        objectOutputStream.flush();
        commands.clear();

        sendShutdown();

        objectOutputStream.close();
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

        commands.add(client);
        commands.add(client2);
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
        commands.add(consultant);
        commands.add(consultant2);

    };

    /**
     * The sendTimeCards method.
     */
    public void sendTimeCards() {
        for (TimeCard tc : timeCards) {
            Command<?> timeCardCommand = new AddTimeCardCommand(tc);
            commands.add(timeCardCommand);
        }
    };

    /**
     * The sendInvoices method.
     */
    public void sendInvoices() {
        Command<?> invoices = new CreateInvoicesCommand(
            LocalDate.of(2017, 03, 01));
        commands.add(invoices);
    }

    /**
     * The sendDisconnect method.
     * 
     * @throws UnknownHostException The exception thrown if a host is unknown.
     * @throws IOException          The exception thrown if an IO issue occurs.
     */
    public void sendDisconnect() throws IOException {
        Command<?> disconnect = new DisconnectCommand();
        commands.add(disconnect);
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
            server.shutdownInput();
            Command<?> shutdown = new ShutdownCommand();
            commands.add(shutdown);
            out.writeObject(commands);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The getHostName getter method.
     * 
     * @return The hostname string.
     */
    public static String getHostName() {
        return hostName;
    }

    /**
     * The setHostName setter.
     * 
     * @param hostName The hostName to be set.
     */
    public static void setHostName(String hostName) {
        InvoiceClient.hostName = hostName;
    }
}
