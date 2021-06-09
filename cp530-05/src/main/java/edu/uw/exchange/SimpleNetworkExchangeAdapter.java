package edu.uw.exchange;

import static edu.uw.exchange.Constants.CLOSED_EVNT;
import static edu.uw.exchange.Constants.ELEMENT_DELIMITER;
import static edu.uw.exchange.Constants.ENCODING;
import static edu.uw.exchange.Constants.OPEN_EVNT;
import static edu.uw.exchange.Constants.PRICE_CHANGE_EVNT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.EventListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.uw.ext.framework.exchange.ExchangeAdapter;
import edu.uw.ext.framework.exchange.ExchangeEvent;
import edu.uw.ext.framework.exchange.ExchangeListener;
import edu.uw.ext.framework.exchange.StockExchange;

public class SimpleNetworkExchangeAdapter
    implements ExchangeAdapter, ExchangeListener, AutoCloseable, EventListener {

    private static int TTL = 2;
    private StockExchange realExchange;
    private MulticastSocket eventSocket;
    private InetAddress multicastGroup;
    private DatagramPacket datagramPacket;
    private SimpleCommandListener cmdListener;
    private ExecutorService cmdListenerExecutor;

    SimpleNetworkExchangeAdapter(StockExchange exchng, String multicastIP,
        int multicastPort, int commandPort) throws UnknownHostException {
        this.realExchange = exchng;
        this.multicastGroup = InetAddress.getByName(multicastIP);
        final byte[] buf = {};
        this.datagramPacket = new DatagramPacket(buf, 0, multicastGroup,
            multicastPort);
        try {
            this.eventSocket = new MulticastSocket();
            eventSocket.joinGroup(multicastGroup);
            eventSocket.setTimeToLive(TTL);

        } catch (IOException exc) {
            exc.printStackTrace();
        }
        this.cmdListener = new SimpleCommandListener(commandPort, realExchange);
        cmdListenerExecutor = Executors.newSingleThreadExecutor();
        cmdListenerExecutor.execute(cmdListener);

        realExchange.addExchangeListener(this);
    };

    private synchronized void sendMulticastEvent(String msg)
        throws IOException {
        final byte[] buf = msg.getBytes(ENCODING);
        datagramPacket.setData(buf);
        datagramPacket.setLength(buf.length);

        eventSocket.send(datagramPacket);
    }

    @Override
    public void exchangeClosed(ExchangeEvent event) {
        try {
            sendMulticastEvent(CLOSED_EVNT);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void exchangeOpened(ExchangeEvent event) {
        try {
            sendMulticastEvent(OPEN_EVNT);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void priceChanged(ExchangeEvent event) {
        String symbol = event.getTicker();
        int price = event.getPrice();
        String msg = String.join(ELEMENT_DELIMITER, PRICE_CHANGE_EVNT, symbol,
            Integer.toString(price));

        try {
            sendMulticastEvent(msg);
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {
        realExchange.removeExchangeListener(this);
        cmdListener.terminate();
        cmdListenerExecutor.shutdownNow();
        try {
            eventSocket.leaveGroup(multicastGroup);
        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            eventSocket.close();
        }
    }

}
