package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.uw.cp520.scg.domain.ClientAccount;
import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.domain.TimeCard;
import edu.uw.ext.util.ListFactory;

/**
 * The InitLists class for the serialization portion of the Invoice/TimeCard
 * project.
 * 
 * @author Toby Peterson.
 *
 */
public class InitLists {

    /**
     * The main method for the InitLists class.
     * 
     * @param args The arguments being used for the main method.
     */
    public static void main(String[] args) {

        // Create lists to be populated by factory
        final List<ClientAccount> accounts = new ArrayList<>();
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        serializeItem(timeCards, "resources/TimeCardList.ser");
        serializeItem(accounts, "resources/ClientList.ser");
    }

    /**
     * The serializable method that serializes the data for the three
     * destrination files.
     * 
     * @param list     The list to be serialized.
     * @param filename The destination file to hold the serialized data.
     */
    public static void serializeItem(List<?> list, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}