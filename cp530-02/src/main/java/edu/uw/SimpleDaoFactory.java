package edu.uw;

import edu.uw.ext.framework.dao.AccountDao;
import edu.uw.ext.framework.dao.DaoFactory;
import edu.uw.ext.framework.dao.DaoFactoryException;

/**
 * The SimpleDaoFactory class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleDaoFactory implements DaoFactory {

    /**
     * The no argument constructor for the SimpleDaoFactory class.
     */
    public SimpleDaoFactory() {
    }

    /**
     * The getAccountDao getter for the class.
     * 
     * @return AccountDao The accountDao to be returned.
     */
    @Override
    public AccountDao getAccountDao() throws DaoFactoryException {
        return new SimpleAccountDao();
    }

}
