package edu.uw.exchange;

public final class Constants {

    public final static String ENCODING = "ISO-8859-1";
    public final static String ELEMENT_DELIMITER = ":";
    public final static String OPEN_EVNT = "OPEN_EVNT";
    public final static String CLOSED_EVNT = "CLOSED_EVNT";
    public final static String PRICE_CHANGE_EVNT = "PRICE_CHANGE_EVNT";
    public final static String OPEN_STATE = "OPEN";
    public final static String CLOSED_STATE = "CLOSED";
    public final static int EVENT_ELEMENT = 0;
    public final static int PRICE_CHANGE_EVNT_TICKER_ELEMENT = 1;
    public final static int PRICE_CHANGE_EVNT_PRICE_ELEMENT = 2;
    public final static String GET_TICKERS_CMD = "GET_TICKERS_CMD";
    public final static String GET_QUOTE_CMD = "GET_QUOTE_CMD";
    public final static String GET_STATE_CMD = "GET_STATE_CMD";
    public final static String EXECUTE_TRADE_CMD = "EXECUTE_TRADE_CMD";
    public final static String BUY_ORDER = "BUY_ORDER";
    public final static String SELL_ORDER = "SELL_ORDER";
    public final static int INVALID_STOCK = -1;
    public final static int CMD_ELEMENT = 0;
    public final static int QUOTE_CMD_TICKER_ELEMENT = 1;
    public final static int EXECUTE_TRADE_CMD_TYPE_ELEMENT = 1;
    public final static int EXECUTE_TRADE_CMD_ACCOUNT_ELEMENT = 2;
    public final static int EXECUTE_TRADE_CMD_TICKER_ELEMENT = 3;
    public final static int EXECUTE_TRADE_CMD_SHARES_ELEMENT = 4;

    private Constants() {
    }
}
