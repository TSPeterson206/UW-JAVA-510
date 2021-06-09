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

/**
 * The Class SimpleBroker for the stock trader project.
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
     * @param brokerName the broker name.
     * @param exchg      the exchg.
     * @param acctMgr    the acct mgr.
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
     * @param brokerName the broker name.
     * @param acctMgr    the acct mgr.
     * @param exchg      the exchg.
     */
    protected SimpleBroker(String brokerName, AccountManager acctMgr,
        StockExchange exchg) {
        this(brokerName, exchg, acctMgr);

        boolean isItOpenOrNot = exchg.isOpen();

        marketOrders = new SimpleOrderQueue<>(isItOpenOrNot,
            (threshold, order) -> threshold, brokerName);
        marketOrders.setConsumer(this::execute);
        initializeOrderManagers();
        exchg.addExchangeListener(this);
    }

    /**
     * Instantiates a new simple broker.
     *
     * @param brokerName the broker name.
     * @param exchg      the exchg.
     * @param acctMgr    the acct mgr.
     */
    protected SimpleBroker(String brokerName, StockExchange exchg,
        SimpleAccountManager acctMgr) {
        this.name = brokerName;
        this.exchange = exchg;
        this.accountManager = acctMgr;
    };

    /**
     * The close method.
     *
     * @throws BrokerException The broker exception thrown.
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
     * The deleteAccount method.
     *
     * @param username The username passed in.
     * @throws BrokerException The broker exception thrown.
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
     * The getAccount method for the SimpleBroker class.
     *
     * @param username The username passed in.
     * @param password The password passed in.
     * @return The account retrieved.
     * @throws BrokerException the broker exception thrown.
     */
    @Override
    public Account getAccount(String username, String password)
        throws BrokerException {
        // Totally forgot there was a validate login method on
        // SimpleAccountManager.

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
     * @return the name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Place order.
     *
     * @param order The order passed in.
     * @throws BrokerException The broker exception thrown.
     */
    @Override
    public void placeOrder(MarketBuyOrder order) throws BrokerException {
        marketOrders.enqueue(order);
    }

    /**
     * Place order.
     *
     * @param order The order.
     * @throws BrokerException The broker exception thrown.
     */
    @Override
    public void placeOrder(MarketSellOrder order) throws BrokerException {
        marketOrders.enqueue(order);
    }

    /**
     * Place order.
     *
     * @param order The order thrown.
     * @throws BrokerException The broker exception thrown.
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
     * @param order The order.
     * @throws BrokerException The broker exception thrown.
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
     * @param ticker The ticker passed in.
     * @return The optional.
     */
    @Override
    public Optional<StockQuote> requestQuote(String ticker) {
        return exchange.getQuote(ticker);
    }

    /**
     * The execute function that will actually be used to reflect the order.
     *
     * @param order The order passed in.
     */
    public void execute(Order order) {
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
        // This was clever so I borrowed it. Thanks for the guidance. Initially
        // had a big messy constructor and removing this logic is much cleaner.
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
