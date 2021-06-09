package edu.uw.exchange;

import static edu.uw.exchange.Constants.CLOSED_EVNT;
import static edu.uw.exchange.Constants.ELEMENT_DELIMITER;
import static edu.uw.exchange.Constants.ENCODING;
import static edu.uw.exchange.Constants.EVENT_ELEMENT;
import static edu.uw.exchange.Constants.OPEN_EVNT;
import static edu.uw.exchange.Constants.PRICE_CHANGE_EVNT;
import static edu.uw.exchange.Constants.PRICE_CHANGE_EVNT_PRICE_ELEMENT;
import static edu.uw.exchange.Constants.PRICE_CHANGE_EVNT_TICKER_ELEMENT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.event.EventListenerList;

import edu.uw.ext.framework.exchange.ExchangeEvent;
import edu.uw.ext.framework.exchange.ExchangeListener;

public class SimpleNetEventProcessor implements Runnable {

    private static int BUFFER_SIZE = 1024;
    private String eventIpAddress;
    private int eventPort;
    private EventListenerList listenerList = new EventListenerList();

    public SimpleNetEventProcessor(String eventIpAddress, int eventPort) {
        this.eventIpAddress = eventIpAddress;
        this.eventPort = eventPort;
    }

    @Override
    public void run() {
        try (MulticastSocket eventSocket = new MulticastSocket(eventPort)) {
            InetAddress eventGroup = InetAddress.getByName(eventIpAddress);
            eventSocket.joinGroup(eventGroup);
            byte[] buf = new byte[BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while (!eventSocket.isClosed()) {
                eventSocket.receive(packet);
                String msg = new String(packet.getData(), packet.getOffset(),
                    packet.getLength(), ENCODING);
                String[] elements = msg.split(ELEMENT_DELIMITER);
                String eventType = elements[EVENT_ELEMENT];

                switch (eventType) {
                case OPEN_EVNT:
                    fireListeners(ExchangeEvent.newOpenedEvent(this));
                    break;

                case CLOSED_EVNT:
                    fireListeners(ExchangeEvent.newClosedEvent(this));
                    break;

                case PRICE_CHANGE_EVNT:
                    String ticker = elements[PRICE_CHANGE_EVNT_TICKER_ELEMENT];
                    String priceStr = elements[PRICE_CHANGE_EVNT_PRICE_ELEMENT];
                    int price = -1;

                    try {
                        price = Integer.parseInt(priceStr);
                    } catch (NumberFormatException exc) {
                        exc.printStackTrace();
                    }
                    fireListeners(ExchangeEvent.newPriceChangedEvent(this,
                        ticker, price));
                    break;

                default:
                    break;
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public void addExchangeListener(ExchangeListener l) {
        listenerList.add(ExchangeListener.class, l);
    }

    public void removeExchangeListener(ExchangeListener l) {
        listenerList.remove(ExchangeListener.class, l);
    }

    private void fireListeners(ExchangeEvent evnt) {
        ExchangeListener[] listeners;
        listeners = listenerList.getListeners(ExchangeListener.class);

        for (ExchangeListener listener : listeners) {
            switch (evnt.getEventType()) {
            case OPENED:
                listener.exchangeOpened(evnt);
                break;

            case CLOSED:
                listener.exchangeClosed(evnt);
                break;

            case PRICE_CHANGED:
                listener.priceChanged(evnt);
                break;

            default:
                break;
            }
        }
    }
}
