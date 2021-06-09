package edu.uw.broker;

import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.broker.Broker;
import edu.uw.ext.framework.broker.BrokerFactory;
import edu.uw.ext.framework.exchange.StockExchange;

/**
 * A factory for creating SimpleBroker objects.
 */
public class SimpleBrokerFactory implements BrokerFactory {

    /**
     * Constructor. Instantiates a new simple broker factory.
     */
    public SimpleBrokerFactory() {

    }

    /**
     * The newBroker method for the SimpleBrokerFactory class.
     *
     * @param name     The name passed in as an argument.
     * @param acctMngr The AccountManager passed in.
     * @param exch     The Exchange passed in.
     * @return Broker The Broker object that is returned.
     */
    @Override
    public Broker newBroker(String name, AccountManager acctMngr,
        StockExchange exch) {
        return new SimpleBroker(name, acctMngr, exch);
    }

}
