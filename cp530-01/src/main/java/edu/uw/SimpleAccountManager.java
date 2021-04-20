package edu.uw;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
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

    /**
     * The one argument constructor for the SimpleAccountManager class.
     * 
     * @param dao The dao argument for the dao property.
     */
    public SimpleAccountManager(SimpleAccountDao dao) {
        this.dao = dao;
    };

    /**
     * The close method for the class.
     */
    @Override
    public void close() throws AccountException {
        dao.close();
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
        System.out
            .println("&&&&&&&&&&&&&&&&&&&&&" + dao.getAccount(accountName));
        if (dao.getAccount(accountName) != null) {
            throw new AccountException("this account already exists!");
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digestBytes = md.digest();
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
    public void deleteAccount(String accountName) throws AccountException {
        dao.deleteAccount(accountName);
    }

    /**
     * The getAccount method for the class.
     * 
     * @param accountName The account to be retrieved.
     */
    @Override
    public Account getAccount(String accountName) throws AccountException {
        return dao.getAccount(accountName);
    }

    /**
     * The persist method.
     * 
     * @param account The account to be persisted.
     */
    @Override
    public void persist(Account account) throws AccountException {
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
    public boolean validateLogin(String arg0, String arg1)
        throws AccountException {
        boolean nameExists = false;
        boolean passwordIsGood = false;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(arg1.getBytes());
        byte[] digestBytes = md.digest();

        if (!dao.getAccount(arg0).equals(null)) {
            nameExists = true;
        }

        if (dao.getAccount(arg0).getPasswordHash().equals(digestBytes)) {
            passwordIsGood = true;
        }
        ;

//        Optional<String> longestString = w.stream().reduce(
//            (word1, word2) -> word1.length() > word2.length() ? word1 : word2);

        String string = new String(dao.getAccount(arg0).getPasswordHash());
        Decoder decoder = Base64.getDecoder();
        String s = Base64.getEncoder()
            .encodeToString(dao.getAccount(arg0).getPasswordHash());

        byte[] bytes = decoder.decode(s);

        System.out.println(string);
        System.out.println(s);
        System.out.println(
            "################" + nameExists + " " + passwordIsGood + " "
                + dao.getAccount(arg0).getPasswordHash() + " " + digestBytes
                + " 5 " + new String(dao.getAccount(arg0).getPasswordHash())
                + " " + arg1 + " " + s + " " + string + " "
                + dao.getAccount(arg0).getPasswordHash().toString() + " "
                + bytes + " " + arg1.getBytes() + " 6 "
                + new String(dao.getAccount(arg0).getPasswordHash(),
                    Charset.forName("US-ASCII")));

        if (nameExists) {
            if (passwordIsGood) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
