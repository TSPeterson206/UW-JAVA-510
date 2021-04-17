package edu.uw;

import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.account.AccountManagerFactory;
import edu.uw.ext.framework.dao.AccountDao;

public class SimpleAccountManagerFactory implements AccountManagerFactory {

    /**
     * 
     */
    @Override
    public AccountManager newAccountManager(AccountDao dao) {
        // TODO Auto-generated method stub
        return new SimpleAccountManager((SimpleAccountDao) dao);
    }
}
