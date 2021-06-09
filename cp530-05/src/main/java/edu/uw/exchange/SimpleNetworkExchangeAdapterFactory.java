package edu.uw.exchange;

import java.net.UnknownHostException;

import edu.uw.ext.framework.exchange.ExchangeAdapter;
import edu.uw.ext.framework.exchange.NetworkExchangeAdapterFactory;
import edu.uw.ext.framework.exchange.StockExchange;

public class SimpleNetworkExchangeAdapterFactory
    implements NetworkExchangeAdapterFactory {

    @Override
    public ExchangeAdapter newAdapter(StockExchange exchange,
        String multicastIP, int multicastPort, int commandPort) {

        ExchangeAdapter exAdapt = null;

        try {
            exAdapt = new SimpleNetworkExchangeAdapter(exchange, multicastIP,
                multicastPort, commandPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return exAdapt;
    }

}
