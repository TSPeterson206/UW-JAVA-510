package edu.uw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.Address;

/**
 * The AddressSer class for the stock tracker project. It is a utility class
 * used to serialize the data for the account address.
 * 
 * @author Toby Peterson.
 *
 */
public class AddressSer {

    /**
     * The addressTag property.
     */
    private static String addressTag = "address";

    /**
     * The cityTag property.
     */
    private static String cityTag = "city";

    /**
     * The stateTag property.
     */
    private static String stateTag = "state";

    /**
     * The zipTag property.
     */
    private static String zipTag = "zip";

    /**
     * The private constructor to prevent instantiation.
     */
    private AddressSer() {
    };

    /**
     * The write method for the AddressSer class.
     * 
     * @param output  The dataoutputstream used for a write.
     * @param address The address object to be written.
     * @throws AccountException The exception thrown when it gives up the ghost.
     */
    public static void write(OutputStream output, Address address)
        throws AccountException {

        Properties props = new Properties();

        if (address != null) {
            String holder;
            holder = address.getStreetAddress();
            if (holder != null) {
                props.put(addressTag, holder);
            }

            holder = address.getCity();
            if (holder != null) {
                props.put(cityTag, holder);
            }

            holder = address.getState();
            if (holder != null) {
                props.put(stateTag, holder);
            }

            holder = address.getZipCode();
            if (holder != null) {
                props.put(zipTag, holder);
            }
        }

        try {
            props.store(output, "Address data");
        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with writing the address", exc);
        }
    }

    /**
     * The read class for the AddressSer class.
     * 
     * @param input The datainputstream used to initiate a read.
     * @return Address The written address object.
     * @throws AccountException The exception thrown when the project sees no
     *                          point in pressing forward.
     */
    public static Address read(InputStream input) throws AccountException {
        Properties props = new Properties();
        try (
            ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "context.xml")) {
            props.load(input);

            Address address = appContext.getBean(Address.class);
            address.setStreetAddress(props.getProperty(addressTag));
            address.setCity(props.getProperty(cityTag));
            address.setState(props.getProperty(stateTag));
            address.setZipCode(props.getProperty(zipTag));

            return address;

        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with reading the address", exc);
        }
    }

}
