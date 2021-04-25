package edu.uw;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountFactory;

/**
 * The SimpleAccountFactory class for the stock trader project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccountFactory implements AccountFactory {

    /**
     * The no parameter constructor for the SimpleAccountFactory class.
     */
    public SimpleAccountFactory() {
    }

    /**
     * The newAccount method for the SimpleAccountFactory class.
     * 
     * @param arg0 The new account name argument.
     * @param arg1 The password argument.
     * @param arg2 The balance argument.
     * @return Account The account created.
     */
    @Override
    public Account newAccount(String arg0, byte[] arg1, int arg2) {

        if (arg0.length() < 8 || arg2 < 100000) {
            return null;
        } else {
            SimpleAccount account = null;
            try {
                account = new SimpleAccount(arg0, arg1, arg2);
            } catch (AccountException e) {
                e.printStackTrace();
            }
            return account;
        }
    }
}
