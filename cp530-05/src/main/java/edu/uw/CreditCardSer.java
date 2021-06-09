package edu.uw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.CreditCard;

/**
 * The CreditCardSer class for the stock tracker project. This is a utility
 * class used to write/read an account creditcard.
 * 
 * @author Toby Peterson.
 *
 */
public class CreditCardSer {

    /**
     * The issuerTag property.
     */
    private static String issuerTag = "issuer";

    /**
     * The typeTag property.
     */
    private static String typeTag = "type";

    /**
     * The holderTag property.
     */
    private static String holderTag = "holder";

    /**
     * The accountNumberTag property.
     */
    private static String accountNumberTag = "accountNumber";

    /**
     * The expDateTag property.
     */
    private static String expDateTag = "expDate";

    /**
     * The private constructor used to prevent instantiation.
     */
    private CreditCardSer() {
    };

    /**
     * The write method for the CreditCardSer class.
     * 
     * @param output The outputstream used to funnel the write.
     * @param card   The creditcard object to be written.
     * @throws UnsupportedEncodingException The exception thrown when there is a
     *                                      lack of support.
     * @throws AccountException             The exception thrown when the
     *                                      project realizes how vulnerable the
     *                                      cryptocurrency market is.
     */
    public static void write(OutputStream output, CreditCard card)
        throws UnsupportedEncodingException, AccountException {

        Properties props = new Properties();

        if (card != null) {
            String holder;
            holder = card.getIssuer();
            if (holder != null) {
                props.put(issuerTag, holder);
            }

            holder = card.getType();
            if (holder != null) {
                props.put(typeTag, holder);
            }

            holder = card.getHolder();
            if (holder != null) {
                props.put(holderTag, holder);
            }

            holder = card.getAccountNumber();
            if (holder != null) {
                props.put(accountNumberTag, holder);
            }

            holder = card.getExpirationDate();
            if (holder != null) {
                props.put(expDateTag, holder);
            }
        }

        try {
            props.store(output, "creditcard data");
        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with writing the creditcard", exc);
        }
    }

    /**
     * The read method for the CreditCardSer class.
     * 
     * @param input The inputstream used to funnel a read.
     * @return CreditCard The CreditCard object read.
     * @throws AccountException The exception thrown when there is something
     *                          wrotten in the state of Denmark.
     */
    public static CreditCard read(InputStream input) throws AccountException {
        Properties props = new Properties();
        try (
            ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "context.xml")) {
            props.load(input);

            CreditCard card = appContext.getBean(CreditCard.class);
            card.setIssuer(props.getProperty(issuerTag));
            card.setType(props.getProperty(typeTag));
            card.setHolder(props.getProperty(holderTag));
            card.setAccountNumber(props.getProperty(accountNumberTag));
            card.setExpirationDate(props.getProperty(expDateTag));

            return card;

        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with reading the address", exc);
        }
    }
}
