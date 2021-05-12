package edu.uw.broker;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

import edu.uw.SimpleAccountManager;
import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.account.AccountManager;
import edu.uw.ext.framework.broker.Broker;
import edu.uw.ext.framework.broker.BrokerException;
import edu.uw.ext.framework.broker.OrderManager;
import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.exchange.ExchangeEvent;
import edu.uw.ext.framework.exchange.ExchangeListener;
import edu.uw.ext.framework.exchange.StockExchange;
import edu.uw.ext.framework.exchange.StockQuote;
import edu.uw.ext.framework.order.MarketBuyOrder;
import edu.uw.ext.framework.order.MarketSellOrder;
import edu.uw.ext.framework.order.Order;
import edu.uw.ext.framework.order.StopBuyOrder;
import edu.uw.ext.framework.order.StopSellOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleBroker.
 */
public class SimpleBroker implements Broker, ExchangeListener {

    /** The name. */
    public String name;

    /** The exchange. */
    public StockExchange exchange;

    /** The account manager. */
    public AccountManager accountManager;

    /** The order manager map. */
    public HashMap<String, OrderManager> orderManagerMap;

    /** The market orders. */
    public OrderQueue<Boolean, Order> marketOrders;

    /**
     * Instantiates a new simple broker.
     *
     * @param brokerName the broker name
     * @param exchg      the exchg
     * @param acctMgr    the acct mgr
     */
    public SimpleBroker(String brokerName, StockExchange exchg,
        AccountManager acctMgr) {
        this.name = brokerName;
        this.exchange = exchg;
        this.accountManager = acctMgr;
    };

    /**
     * Instantiates a new simple broker.
     *
     * @param brokerName the broker name
     * @param acctMgr    the acct mgr
     * @param exchg      the exchg
     */
    protected SimpleBroker(String brokerName, AccountManager acctMgr,
        StockExchange exchg) {
        this(brokerName, exchg, acctMgr);

        boolean isItOpenOrNot = exchg.isOpen();

        marketOrders = new SimpleOrderQueue<>(isItOpenOrNot,
            (threshold, order) -> threshold);
        marketOrders.setConsumer(this::executeOrder);
        initializeOrderManagers();
        exchg.addExchangeListener(this);
    }

    /**
     * Instantiates a new simple broker.
     *
     * @param brokerName the broker name
     * @param exchg      the exchg
     * @param acctMgr    the acct mgr
     */
    protected SimpleBroker(String brokerName, StockExchange exchg,
        SimpleAccountManager acctMgr) {
        this.name = brokerName;
        this.exchange = exchg;
        this.accountManager = acctMgr;
    };

    /**
     * Close.
     *
     * @throws BrokerException the broker exception
     */
    @Override
    public void close() throws BrokerException {
        try {
            exchange.removeExchangeListener(this);
            accountManager.close();
            orderManagerMap.clear();
        } catch (AccountException e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates the account.
     *
     * @param username the username
     * @param password the password
     * @param balance  the balance
     * @return the account
     * @throws BrokerException the broker exception
     */
    @Override
    public Account createAccount(String username, String password, int balance)
        throws BrokerException {
        Account account = null;
        try {
            account = accountManager.createAccount(username, password, balance);
        } catch (AccountException e) {
            System.out.println("failed account creation: " + username);
            e.printStackTrace();
        }
        return account;
    }

    /**
     * Delete account.
     *
     * @param username the username
     * @throws BrokerException the broker exception
     */
    @Override
    public void deleteAccount(String username) throws BrokerException {
        try {
            accountManager.deleteAccount(username);
        } catch (AccountException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the account.
     *
     * @param username the username
     * @param password the password
     * @return the account
     * @throws BrokerException the broker exception
     */
    @Override
    public Account getAccount(String username, String password)
        throws BrokerException {

        boolean status = false;
        byte[] pw = null;
        MessageDigest digest = null;
        Account account = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes("ISO-8859-1"));

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }

        byte[] hashedpw = digest.digest();

        try {
            account = accountManager.getAccount(username);
            if (account != null) {
                pw = account.getPasswordHash();
            }
            status = MessageDigest.isEqual(pw, hashedpw);

        } catch (AccountException e) {
            e.printStackTrace();
        }

        if (status) {
            return account;
        } else {
            throw new BrokerException();
        }
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Place order.
     *
     * @param order the order
     * @throws BrokerException the broker exception
     */
    @Override
    public void placeOrder(MarketBuyOrder order) throws BrokerException {
        marketOrders.enqueue(order);
    }

    /**
     * Place order.
     *
     * @param order the order
     * @throws BrokerException the broker exception
     */
    @Override
    public void placeOrder(MarketSellOrder order) throws BrokerException {
        marketOrders.enqueue(order);
    }

    /**
     * Place order.
     *
     * @param order the order
     * @throws BrokerException the broker exception
     */
    @Override
    public void placeOrder(StopBuyOrder order) throws BrokerException {
        OrderManager om = orderManagerMap.get(order.getStockTicker());
        if (om != null) {
            om.queueOrder(order);
        }

    }

    /**
     * Place order.
     *
     * @param order the order
     * @throws BrokerException the broker exception
     */
    @Override
    public void placeOrder(StopSellOrder order) throws BrokerException {
        OrderManager om = orderManagerMap.get(order.getStockTicker());
        if (om != null) {
            om.queueOrder(order);
        }
    }

    /**
     * Request quote.
     *
     * @param ticker the ticker
     * @return the optional
     */
    @Override
    public Optional<StockQuote> requestQuote(String ticker) {
        return exchange.getQuote(ticker);
    }

    /**
     * Execute order.
     *
     * @param order the order
     */
    public void executeOrder(Order order) {
        try {
            Account account = accountManager.getAccount(order.getAccountId());
            account.reflectOrder(order, exchange.executeTrade(order));
        } catch (AccountException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Initialize order managers.
     */
    protected void initializeOrderManagers() {
        orderManagerMap = new HashMap<>();
        Consumer<StopBuyOrder> buyOrders = (StopBuyOrder order) -> marketOrders
            .enqueue(order);
        Consumer<StopSellOrder> sellOrders = (
            StopSellOrder order) -> marketOrders.enqueue(order);

        Consumer<StockQuote> addStockAction = (quote) -> {
            final int price = quote.getPrice();
            final String ticker = quote.getTicker();

            OrderManager om = new SimpleOrderManager(ticker, price);
            om.setBuyOrderProcessor(buyOrders);
            om.setSellOrderProcessor(sellOrders);
            orderManagerMap.put(ticker, om);
        };

        for (String ticker : exchange.getTickers()) {
            Optional<StockQuote> quote = exchange.getQuote(ticker);

            if (quote != null) {
                quote.ifPresent(addStockAction);
            }

        }
    }

    /**
     * Creates the order manager.
     *
     * @param ticker the ticker
     * @param price  the price
     * @return the order manager
     */
//    protected OrderManager createOrderManager(String ticker, int price) {
//        return new SimpleOrderManager(ticker, price);
//    }

    /**
     * Exchange opened.
     *
     * @param event the event
     */
    public void exchangeOpened(ExchangeEvent event) {
        marketOrders.setThreshold(true);
    }

    /**
     * Exchange closed.
     *
     * @param event the event
     */
    public void exchangeClosed(ExchangeEvent event) {
        marketOrders.setThreshold(false);
    }

    /**
     * Price changed.
     *
     * @param event the event
     */
    public void priceChanged(ExchangeEvent event) {
        OrderManager om = orderManagerMap.get(event.getTicker());
        if (om != null) {
            om.adjustPrice(event.getPrice());
        }

    }
}
