package edu.uw.exchange;

import edu.uw.ext.framework.exchange.NetworkExchangeProxyFactory;
import edu.uw.ext.framework.exchange.StockExchange;

public class SimpleNetworkExchangeProxyFactory
    implements NetworkExchangeProxyFactory {

    @Override
    public StockExchange newProxy(String multicastIP, int multicastPort,
        String commandIP, int commandPort) {
        return new SimpleNetworkExchangeProxy(multicastIP, multicastPort,
            commandIP, commandPort);
    }

}
