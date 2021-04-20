package edu.uw;

import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.account.AccountManagerFactory;
import edu.uw.ext.framework.dao.AccountDao;

/**
 * The SimpleAccountManagerFactory class for the stock trader project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccountManagerFactory implements AccountManagerFactory {

    /**
     * The newAccountManager method for the class.
     * 
     * @param dao The dao to be passed as an argument.
     * @return AccountManager The account manager returned.
     */
    @Override
    public AccountManager newAccountManager(AccountDao dao) {
        // TODO Auto-generated method stub
        return new SimpleAccountManager((SimpleAccountDao) dao);
    }
}
