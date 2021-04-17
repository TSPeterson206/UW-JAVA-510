package edu.uw;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountFactory;

public class SimpleAccountFactory implements AccountFactory {

    public SimpleAccountFactory() {
    }

    @Override
    public Account newAccount(String arg0, byte[] arg1, int arg2) {

        if (arg0.length() < 8 || arg2 < 100000) {
            System.out
                .println("bad name or balance*****************************"
                    + arg0 + " " + arg0.length() + " " + arg2);
            return null;
        } else {
            SimpleAccount account = null;
            try {
                account = new SimpleAccount(arg0, arg1, arg2);
            } catch (AccountException e) {
                e.printStackTrace();
            }
            System.out
                .println("Good name and balance*****************************"
                    + arg0 + " " + arg0.length() + " " + arg2);
            return account;
        }
    }
}
