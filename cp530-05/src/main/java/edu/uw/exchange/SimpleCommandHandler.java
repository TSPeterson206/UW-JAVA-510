package edu.uw.exchange;

import static edu.uw.exchange.Constants.BUY_ORDER;
import static edu.uw.exchange.Constants.CLOSED_STATE;
import static edu.uw.exchange.Constants.CMD_ELEMENT;
import static edu.uw.exchange.Constants.ELEMENT_DELIMITER;
import static edu.uw.exchange.Constants.ENCODING;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD_ACCOUNT_ELEMENT;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD_SHARES_ELEMENT;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD_TICKER_ELEMENT;
import static edu.uw.exchange.Constants.EXECUTE_TRADE_CMD_TYPE_ELEMENT;
import static edu.uw.exchange.Constants.GET_QUOTE_CMD;
import static edu.uw.exchange.Constants.GET_STATE_CMD;
import static edu.uw.exchange.Constants.GET_TICKERS_CMD;
import static edu.uw.exchange.Constants.INVALID_STOCK;
import static edu.uw.exchange.Constants.OPEN_STATE;
import static edu.uw.exchange.Constants.QUOTE_CMD_TICKER_ELEMENT;

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

import edu.uw.ext.framework.exchange.StockExchange;
import edu.uw.ext.framework.exchange.StockQuote;
import edu.uw.ext.framework.order.MarketBuyOrder;
import edu.uw.ext.framework.order.MarketSellOrder;
import edu.uw.ext.framework.order.Order;

public class SimpleCommandHandler implements Runnable {

    private Socket socket;
    private StockExchange realExchange;

    public SimpleCommandHandler(Socket sock, StockExchange realExchange) {
        socket = sock;
        this.realExchange = realExchange;
    }

    @Override
    public void run() {
        try {
            Socket localSocket = socket;
            InputStream inStrm = localSocket.getInputStream();
            Reader rdr = new InputStreamReader(inStrm, ENCODING);
            BufferedReader br = new BufferedReader(rdr);

            OutputStream outStrm = localSocket.getOutputStream();
            Writer wrtr = new OutputStreamWriter(outStrm, ENCODING);
            PrintWriter prntWrtr = new PrintWriter(wrtr, true);

            String msg = br.readLine();
            if (msg == null) {
                msg = "";
            }

            String[] elements = msg.split(ELEMENT_DELIMITER);
            final String cmd = elements[CMD_ELEMENT];

            switch (cmd) {
            case GET_STATE_CMD:
                doGetState(prntWrtr);
                break;

            case GET_TICKERS_CMD:
                doGetTickers(prntWrtr);
                break;

            case GET_QUOTE_CMD:
                doGetQuote(elements, prntWrtr);
                break;

            case EXECUTE_TRADE_CMD:
                doExecuteTrade(elements, prntWrtr);
                break;

            default:
                break;
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private void doGetState(PrintWriter prntWrtr) {
        String response = realExchange.isOpen() ? OPEN_STATE : CLOSED_STATE;

        prntWrtr.println(response);
    }

    private void doGetTickers(PrintWriter prntWrtr) {
        String[] tickers = realExchange.getTickers();
        String tickersStr = String.join(ELEMENT_DELIMITER, tickers);
        prntWrtr.println(tickersStr);
    }

    private void doGetQuote(String[] elements, PrintWriter prntWrtr) {
        String ticker = elements[QUOTE_CMD_TICKER_ELEMENT];
        Optional<StockQuote> quoteOpt = realExchange.getQuote(ticker);
        quoteOpt.ifPresentOrElse(q -> prntWrtr.println(q.getPrice()),
            () -> prntWrtr.println(INVALID_STOCK));
    }

    private void doExecuteTrade(String[] elements, PrintWriter prntWrtr) {
        if (realExchange.isOpen()) {
            String orderType = elements[EXECUTE_TRADE_CMD_TYPE_ELEMENT];
            String acctId = elements[EXECUTE_TRADE_CMD_ACCOUNT_ELEMENT];
            String ticker = elements[EXECUTE_TRADE_CMD_TICKER_ELEMENT];
            String shares = elements[EXECUTE_TRADE_CMD_SHARES_ELEMENT];
            int qty = -1;

            try {
                qty = Integer.parseInt(shares);
            } catch (NumberFormatException exc) {
                exc.printStackTrace();
            }
            Order order;

            if (BUY_ORDER.equals(orderType)) {
                order = new MarketBuyOrder(acctId, qty, ticker);
            } else {
                order = new MarketSellOrder(acctId, qty, ticker);
            }

            int price = realExchange.executeTrade(order);
            prntWrtr.println(price);
        } else {
            prntWrtr.println(0);
        }
    }

}
