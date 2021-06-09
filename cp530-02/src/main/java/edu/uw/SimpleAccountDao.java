package edu.uw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.Address;
import edu.uw.ext.framework.account.CreditCard;

/**
 * The SimpleAccountDao class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccountDao implements edu.uw.ext.framework.dao.AccountDao {

    /**
     * The accountFile property.
     */
    private String accountFile = "account.dat";

    /**
     * The addressFile property.
     */
    private String addressFile = "address.properties";

    /**
     * The creditCardFile property.
     */
    private String creditCardFile = "card.properties";

    /**
     * The accountsDirectory property.
     */
    private File accountsDirectory = new File("target", "accounts");

    /**
     * The JSON file property.
     */
    private File accountFileJSON;

    /**
     * The objectmapper property.
     */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * The SimpleAccountDao no argument constructor.
     */
    public SimpleAccountDao() {
        SimpleModule module = new SimpleModule();
        module.addAbstractTypeMapping(Address.class, SimpleAddress.class);
        module.addAbstractTypeMapping(CreditCard.class, SimpleCreditCard.class);
        mapper.registerModule(module);
    };

    /**
     * The close method for the SimpleAccountDao class.
     */
    @Override
    public void close() throws AccountException {
        // Currently a stub
    }

    /**
     * The deleteAccount method for the SimpleAccountDao class.
     * 
     * @param accountName The account name to be deleted.
     */
    @Override
    public void deleteAccount(String accountName) throws AccountException {
        delete(new File(accountsDirectory, accountName));
    }

    /**
     * The getAccount method for the SimpleAccountDao class.
     * 
     * @param accountName The account name to be retrieved.
     * @return Account The account to be returned.
     */
    @Override
    public Account getAccount(String accountName) {
        Account account = null;
        File directory = new File(accountsDirectory, accountName);

        if (directory.exists() && directory.isDirectory()) {

            try {
                File inputFile = new File(directory,
                    "/" + accountName + ".json");

                File filePath = new File(
                    accountsDirectory.toPath() + "/" + accountName + ".json");

                account = mapper.readValue(filePath, SimpleAccount.class);

                inputFile = new File(directory, addressFile);
                if (inputFile.exists()) {
                    try (FileInputStream addressIn = new FileInputStream(
                        inputFile)) {
                        Address address = AddressSer.read(addressIn);
                        account.setAddress(address);
                    }
                }
                inputFile = new File(directory, creditCardFile);
                if (inputFile.exists()) {
                    try (FileInputStream cardIn = new FileInputStream(
                        inputFile)) {
                        CreditCard card = CreditCardSer.read(cardIn);
                        account.setCreditCard(card);
                    }
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            } catch (AccountException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    /**
     * The reset method for the SimpleAccountDao class.
     */
    @Override
    public void reset() throws AccountException {
        delete(accountsDirectory);
    }

    /**
     * The setAccount method for the SimpleAccountDao class.
     * 
     * @param account The account to be set.
     */
    @Override
    public void setAccount(Account account) throws AccountException {
        try {
            File acctDirectory = new File(accountsDirectory, account.getName());
            Address address = account.getAddress();
            CreditCard card = account.getCreditCard();

            delete(acctDirectory);
            if (!acctDirectory.exists()) {
                boolean weGotAWinner = acctDirectory.mkdirs();

                if (!weGotAWinner) {
                    throw new AccountException("Couldnt create the directory!");
                }
            }

            accountFileJSON = new File(
                accountsDirectory + "/" + account.getName() + ".json");

            mapper.writeValue(accountFileJSON, account);

            File outFile = new File("target/accounts/", accountFile);

            if (address != null) {
                outFile = new File("target/accounts/", addressFile);

                try (FileOutputStream addressOut = new FileOutputStream(
                    outFile)) {
                    AddressSer.write(addressOut, address);
                }
            }

            if (card != null) {
                outFile = new File("target/accounts/", creditCardFile);

                try (FileOutputStream cardOut = new FileOutputStream(outFile)) {
                    CreditCardSer.write(cardOut, card);
                }
            }
        } catch (IOException exc) {
            throw new AccountException(
                "Houston, we have a problem storing the account!", exc);
        }

    }

    /**
     * The delete method for SimpleAccountDao. This can
     * 
     * @param file The file to be deleted.
     */
    public void delete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File current : files) {
                        delete(current);
                    }
                }
            }
            try {
                Files.delete(file.toPath());
            } catch (IOException exc) {
                exc.printStackTrace();
            }

        }
    }
}