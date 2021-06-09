package edu.uw.exchange;

import static edu.uw.exchange.Constants.BUY_ORDER;
import static edu.uw.exchange.Constants.ELEMENT_DELIMITER;
import static edu.uw.exchange.Constants.ENCODING;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD;
import static edu.uw.exchange.Constants.GET_QUOTE_CMD;
import static edu.uw.exchange.Constants.GET_STATE_CMD;
import static edu.uw.exchange.Constants.GET_TICKERS_CMD;
import static edu.uw.exchange.Constants.INVALID_STOCK;
import static edu.uw.exchange.Constants.OPEN_STATE;
import static edu.uw.exchange.Constants.SELL_ORDER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.Optional;
import java.util.concurrent.Executors;

import javax.swing.event.EventListenerList;

import edu.uw.ext.framework.exchange.ExchangeListener;
import edu.uw.ext.framework.exchange.StockExchange;
import edu.uw.ext.framework.exchange.StockQuote;
import edu.uw.ext.framework.order.Order;

public class SimpleNetworkExchangeProxy implements StockExchange {

    private EventListenerList listenerList = new EventListenerList();

    private String commandIpAddress;
    private int commandPort;
    private SimpleNetEventProcessor eventProcessor;

    public SimpleNetworkExchangeProxy(String eventIpAddress, int eventPort,
        String cmdIpAddress, int cmdPort) {
        commandIpAddress = cmdIpAddress;
        commandPort = cmdPort;
        eventProcessor = new SimpleNetEventProcessor(eventIpAddress, eventPort);
        Executors.newSingleThreadExecutor().execute(eventProcessor);
    };

    @Override
    public void addExchangeListener(ExchangeListener l) {
        eventProcessor.addExchangeListener(l);
    }

    @Override
    public void removeExchangeListener(ExchangeListener l) {
        eventProcessor.removeExchangeListener(l);

    }

    @Override
    public int executeTrade(Order order) {
        String orderType = (order.isBuyOrder()) ? BUY_ORDER : SELL_ORDER;
        String cmd = String.join(ELEMENT_DELIMITER, EXECUTE_TRADE_CMD,
            orderType, order.getAccountId(), order.getStockTicker(),
            Integer.toString(order.getNumberOfShares()));
        String response = sendTcpCmd(cmd);
        int executionPrice = 0;

        try {
            executionPrice = Integer.parseInt(response);
        } catch (NumberFormatException exc) {
            exc.printStackTrace();
        }
        return executionPrice;
    }

    @Override
    public Optional<StockQuote> getQuote(String ticker) {
        String cmd = String.join(ELEMENT_DELIMITER, GET_QUOTE_CMD, ticker);
        String response = sendTcpCmd(cmd);
        int price = INVALID_STOCK;

        try {
            price = Integer.parseInt(response);
        } catch (NumberFormatException exc) {
            exc.printStackTrace();
        }
        Optional<StockQuote> quote = (price >= 0)
            ? Optional.of(new StockQuote(ticker, price))
            : Optional.<StockQuote>empty();

        return quote;

    }

    @Override
    public String[] getTickers() {
        String response = sendTcpCmd(GET_TICKERS_CMD);
        return response.split(ELEMENT_DELIMITER);
    }

    @Override
    public boolean isOpen() {
        String response = sendTcpCmd(GET_STATE_CMD);
        return OPEN_STATE.equals(response);
    }

    private String sendTcpCmd(String cmd) {
        String response = "";
        try (Socket sock = new Socket(commandIpAddress, commandPort);
            InputStream inStrm = sock.getInputStream();
            Reader rdr = new InputStreamReader(inStrm, ENCODING);
            BufferedReader br = new BufferedReader(rdr);
            OutputStream outStrm = sock.getOutputStream();
            Writer wrtr = new OutputStreamWriter(outStrm, ENCODING);
            PrintWriter prntWrtr = new PrintWriter(wrtr, true);) {
            prntWrtr.println(cmd);
            response = br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return response;
    }

}
