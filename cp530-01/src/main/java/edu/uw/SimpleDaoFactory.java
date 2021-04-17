package edu.uw;

import edu.uw.ext.framework.dao.AccountDao;
import edu.uw.ext.framework.dao.DaoFactory;
import edu.uw.ext.framework.dao.DaoFactoryException;

public class SimpleDaoFactory implements DaoFactory {

    public SimpleDaoFactory() {
    }

    @Override
    public AccountDao getAccountDao() throws DaoFactoryException {
        return new SimpleAccountDao();
    }

}
