package edu.uw;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uw.dao.SimpleAccountDao;
import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountFactory;
import edu.uw.ext.framework.account.AccountManager;

/**
 * The SimpleAccountManager class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccountManager implements AccountManager {

    /**
     * The dao property.
     */
    private SimpleAccountDao dao;

    @SuppressWarnings("unused")
    private AccountFactory accountFactory;

    /**
     * The one argument constructor for the SimpleAccountManager class.
     * 
     * @param dao2 The dao argument for the dao property.
     */
    public SimpleAccountManager(SimpleAccountDao dao2) {
        this.dao = dao2;
        try (
            ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                "context.xml");) {
            accountFactory = appContext.getBean(AccountFactory.class);
        } catch (BeansException exc) {
            exc.printStackTrace();
        }
    };

    /**
     * The close method for the class.
     */
    @Override
    public void close() throws AccountException {
        dao.close();
        dao = null;
    }

    /**
     * The createAccount method for the class.
     * 
     * @param accountName The name argument.
     * @param password    The password argument.
     * @param balance     The balance argument.
     */
    @Override
    public Account createAccount(String accountName, String password,
        int balance) throws AccountException {
        if (dao.getAccount(accountName) != null) {
            throw new AccountException("this account already exists!");
        }
        byte[] digestBytes = hashPassword(password);
        SimpleAccount account = new SimpleAccount(accountName, digestBytes,
            balance);
        dao.setAccount(account);
        return account;
    }

    /**
     * The deleteAccount method for the class.
     * 
     * @param accountName The account name to be deleted.
     */
    @Override
    public synchronized void deleteAccount(String accountName)
        throws AccountException {
        dao.deleteAccount(accountName);
    }

    /**
     * The getAccount method for the class.
     * 
     * @param accountName The account to be retrieved.
     */
    @Override
    public synchronized Account getAccount(String accountName)
        throws AccountException {
        Account account = dao.getAccount(accountName);
        if (account != null) {
            account.registerAccountManager(this);
        }
        return account;
    }

    /**
     * The persist method.
     * 
     * @param account The account to be persisted.
     */
    @Override
    public synchronized void persist(Account account) throws AccountException {
        dao.setAccount(account);
    }

    /**
     * The validateLogin method for the class.
     * 
     * @param arg0 The account name.
     * @param arg1 The plaintext password to check against the established
     *             password for an account.
     * @return boolean The boolean incdicating whether or not the login info is
     *         valid.
     */
    @Override
    public synchronized boolean validateLogin(String arg0, String arg1)
        throws AccountException {

        boolean valid = false;
        Account account = getAccount(arg0);

        if (account != null) {
            byte[] pwHash = hashPassword(arg1);
            valid = MessageDigest.isEqual(account.getPasswordHash(), pwHash);
        }

        return valid;

    }

    /**
     * The hashPassword method.
     * 
     * @param password The password string to be hashed.
     * @return byte[] The password returned as an array of bytes.
     * @throws AccountException The exception thrown when secret secrets are no
     *                          fun because secret secrets hurt someone.
     */
    public byte[] hashPassword(String password) throws AccountException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes("ISO-8859-1"));
            return digest.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException exc) {
            throw new AccountException("cant hash the password");
        }
    }
}
