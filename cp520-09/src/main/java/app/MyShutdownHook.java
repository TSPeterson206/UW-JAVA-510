package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;

/**
 * The MyShutdownHook class/shutdown hook for the project.
 * 
 * @author Toby Peterson.
 *
 */
public class MyShutdownHook extends Thread {

    /**
     * The clientList property.
     */
    private List<ClientAccount> clientList;

    /**
     * The consultantList property.
     */
    private List<Consultant> consultantList;

    /**
     * The outputName property.
     */
    private String outputName;

    /**
     * The encoding property.
     */
    private static String ENCODING = "ISO-8859-1";

    /**
     * The MyShutdownHook constructor.
     * 
     * @param clientList     The client list.
     * @param consultantList The consultant list.
     * @param outputName     The output directory name.
     */
    public MyShutdownHook(List<ClientAccount> clientList,
        List<Consultant> consultantList, String outputName) {
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.outputName = outputName;

    }

    /**
     * The run method for the shutdown hook.
     */
    @Override
    public void run() {
        File serverDirectory = new File(outputName);
        if (serverDirectory.exists() || serverDirectory.mkdirs()) {
            File clients = new File(serverDirectory, "ListOfClients.txt");
            File consultants = new File(serverDirectory,
                "ListOfConsultants.txt");

            try (
                PrintStream clientOut = new PrintStream(
                    new FileOutputStream(clients), true, ENCODING);
                PrintStream consultantOut = new PrintStream(
                    new FileOutputStream(consultants), true, ENCODING);) {
                synchronized (clientList) {
                    for (ClientAccount client : clientList) {
                        clientOut.println(client.toString());
                    }
                }
                synchronized (consultantList) {
                    for (Consultant consultant : consultantList) {
                        consultantOut.println(consultant);
                    }
                }
                System.out.println(
                    "Client and consultants listed printed via the shutdown hook in target/server");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Cant create shutdown hook output directory");
        }
    }
}