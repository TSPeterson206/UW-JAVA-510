package edu.uw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;

/**
 * The AccountSer class for the stock tracker project. This is a utility class
 * to assist in serializing data for the individual accounts.
 * 
 * @author Toby Peterson.
 *
 */
public class AccountSer {

    private static ObjectMapper mapper = new ObjectMapper();

    private static File accountFile;

    static HashMap<String, Object> list = new HashMap<>();

    private static TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
    };

    /**
     * The private constructor to prevent instantiation.
     */
    private AccountSer() {
    };

    /**
     * The write method for the AccountSer class.
     * 
     * @param output  The output stream to use with a dataoutputstream to funnel
     *                the data to a write.
     * @param account The account to be written.
     * @throws AccountException        The exception thrown when something has
     *                                 gone awry.
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    public static void write(OutputStream output, Account account)
        throws AccountException, JsonGenerationException, JsonMappingException,
        IOException {

        System.out.println("AccountWriteBeforeFile: " + account.getName());

        list.put(account.getName(), account);

        // Create a file
//        accountFile = new File("target/accounts/" + account.getName() + "/"
//            + account.getName() + ".json");
//
//        System.out.println("AccountWriteAfterFile: " + accountFile.toString());
//
//        // Write it out
//        mapper.writeValue(accountFile, account);

//        Portfolio px = mapper.readValue(file, Portfolio.class);
        // Print the copy
//        System.out.println(px);

        try {
            DataOutputStream dataOut = new DataOutputStream(output);
            dataOut.writeUTF(account.getName());
            writeByteArray(dataOut, account.getPasswordHash());
            dataOut.writeInt(account.getBalance());
            writeNullableString(dataOut, account.getFullName());
            writeNullableString(dataOut, account.getPhone());
            writeNullableString(dataOut, account.getEmail());
            dataOut.flush();
        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with writing the account. Abandon all hope.",
                exc);
        }
    }

    /**
     * The read method for the AccountSer class.
     * 
     * @param input The input stream to use with a dataoutputstream to funnel
     *              the data to a read.
     * @return Account An account object.
     * @throws AccountException     The exception thrown when something has gone
     *                              off the rails.
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static Account read(InputStream input, String accountName)
        throws AccountException, JsonParseException, JsonMappingException,
        IOException {
        DataInputStream dataIn = new DataInputStream(input);
        try (
            ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "context.xml")) {
            Account account = appContext.getBean(Account.class);

            while (dataIn.available() > 0) {
                account.setName(dataIn.readUTF());
                account.setPasswordHash(readByteArray(dataIn));
                account.setBalance(dataIn.readInt());
                account.setFullName(readNullableString(dataIn));
                account.setPhone(readNullableString(dataIn));
                account.setEmail(readNullableString(dataIn));
            }

            return account;

        } catch (EOFException exc) {
            throw new AccountException(
                "Something went wrong with reading the account3", exc);
        } catch (BeansException exc) {
            throw new AccountException(
                "Something went wrong with reading the account2", exc);
        } catch (IOException exc) {
            throw new AccountException(
                "Something went wrong with reading the account", exc);
        }

//        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
//        File readFile = "target/accounts/" + accountName + ".json";

//        System.out.println("AccountReadBeforeMapper: " + accountFile.getPath());
//
//        SimpleAccount account = mapper.readValue(accountFile,
//            SimpleAccount.class);
//
////        SimpleAccount account2 = mapper.readValue(accountFile,
////            list);
//
////        SimpleAccount newone = mapper.readValue(accountFile,
////            SimpleAccount.class);
////        HashMap<String, Object> o = mapper.readValues(accountFile, list);
//
////        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$" + list + accountName
////            + "lets hope: " + list.get(accountName) + " " + account.getName());
//        return account;
    }

    /**
     * The readByteArray method used to read an array of byte. This is used
     * specifically for the password.
     * 
     * @param dataIn The datainputstream to be used for a read.
     * @return byte[] An array of byres.
     * @throws IOException The exception to be thrown when all is lost.
     */
    public static byte[] readByteArray(DataInputStream dataIn)
        throws IOException {
        byte[] bytes = null;
        int length = dataIn.readInt();

        if (length >= 0) {
            bytes = new byte[length];
            dataIn.readFully(bytes);
        }
        return bytes;
    }

    /**
     * The writeByteArray method for the AccountSer class. This is used to write
     * a byte array to a dataoutputstream.
     * 
     * @param dataOut The dataoutputstream to be used for a write.
     * @param bytes   The bytes to be written.
     * @throws IOException The exception thrown when the project has just had
     *                     enough.
     */
    public static void writeByteArray(DataOutputStream dataOut, byte[] bytes)
        throws IOException {
        int length = bytes.length;
        dataOut.writeInt(length);

        if (length > 0) {
            dataOut.write(bytes);
        }
    }

    /**
     * The writeNullableStream method for the AccountSer class.
     * 
     * @param output The dataoutputstream to be used for a write.
     * @param str    The string to be written.
     * @throws IOException The exception thrown when says "deuces!" and just
     *                     leaves.
     */
    public static void writeNullableString(DataOutputStream output, String str)
        throws IOException {
        output.writeUTF(str == null ? "<null>" : str);
    }

    /**
     * @param input The datainputstream to be used for a read.
     * @return String The string that is returned.
     * @throws IOException The exception thrown when the motivation level just
     *                     hits rock bottom.
     */
    public static String readNullableString(DataInputStream input)
        throws IOException {
        String str = input.readUTF();
        return "<null>".equals(str) ? null : str;
    }
}
