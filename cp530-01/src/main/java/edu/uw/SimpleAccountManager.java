package edu.uw;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountManager;

public class SimpleAccountManager implements AccountManager {

    private SimpleAccountDao dao;

    public SimpleAccountManager(SimpleAccountDao dao) {
        this.dao = dao;
    };

    @Override
    public void close() throws AccountException {
        dao.close();
    }

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
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digestBytes = md.digest();
        SimpleAccount account = new SimpleAccount(accountName, digestBytes,
            balance);
        dao.setAccount(account);
        return account;
//        return null;
    }

    @Override
    public void deleteAccount(String accountName) throws AccountException {
        dao.deleteAccount(accountName);
    }

    @Override
    public Account getAccount(String accountName) throws AccountException {
        return dao.getAccount(accountName);
    }

    @Override
    public void persist(Account account) throws AccountException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean validateLogin(String arg0, String arg1)
        throws AccountException {
        boolean nameExists = false;
        boolean passwordIsGood = false;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(arg1.getBytes());
        byte[] digestBytes = md.digest();

        if (dao.getAccount(arg0) != null) {
            nameExists = true;
        }

        if (dao.getAccount(arg0).getPasswordHash() == digestBytes) {
            passwordIsGood = true;
        }
        ;

        String string = new String(dao.getAccount(arg0).getPasswordHash());
        Decoder decoder = Base64.getDecoder();
        String s = Base64.getEncoder()
            .encodeToString(dao.getAccount(arg0).getPasswordHash());

        byte[] bytes = decoder.decode(s);

        System.out.println(string);
        System.out.println(s);
        System.out.println("################" + nameExists + " "
            + passwordIsGood + " " + dao.getAccount(arg0).getPasswordHash()
            + " " + digestBytes + " "
            + new String(dao.getAccount(arg0).getPasswordHash()) + " " + arg1
            + " " + s + " " + string + " "
            + dao.getAccount(arg0).getPasswordHash().toString() + " " + bytes);

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
