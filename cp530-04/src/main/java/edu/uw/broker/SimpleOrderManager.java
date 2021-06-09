package edu.uw.broker;

import java.util.Comparator;
import java.util.function.Consumer;

import edu.uw.ext.framework.broker.OrderManager;
import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.order.StopBuyOrder;
import edu.uw.ext.framework.order.StopSellOrder;

/**
 * The Class SimpleOrderManager.
 */
public class SimpleOrderManager implements OrderManager {

    /** The symbol. */
    private String symbol;

    /** The stop buy order queue. */
    protected OrderQueue<Integer, StopBuyOrder> stopBuyOrderQueue;

    /** The stop sell order queue. */
    protected OrderQueue<Integer, StopSellOrder> stopSellOrderQueue;

    /**
     * Instantiates a new simple order manager.
     *
     * @param stockTickerSymbol the stock ticker symbol
     * @param price             the price
     */
    public SimpleOrderManager(String stockTickerSymbol, int price) {
        this.symbol = stockTickerSymbol;

        // Lifted this from the homework presentation lecture. Consider it an
        // homage. Inspired me to dive into method references and it was a good
        // opportunity for learning. Thanks Russ!
        stopBuyOrderQueue = new SimpleOrderQueue<>(price,
            (threshold, order) -> order.getPrice() <= threshold,
            Comparator.comparing(StopBuyOrder::getPrice)
                .thenComparing(StopBuyOrder::compareTo),
            symbol + "-stopbuy");

        stopSellOrderQueue = new SimpleOrderQueue<>(price,
            (threshold, order) -> order.getPrice() >= threshold,
            Comparator.comparing(StopSellOrder::getPrice).reversed()
                .thenComparing(StopSellOrder::compareTo),
            symbol + "-stopsell");

    };

    /**
     * Adjust price.
     *
     * @param price the price
     */
    @Override
    public void adjustPrice(int price) {
        stopBuyOrderQueue.setThreshold(price);
        stopSellOrderQueue.setThreshold(price);
    }

    /**
     * Gets the symbol.
     *
     * @return the symbol
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * Queue order.
     *
     * @param order the order
     */
    @Override
    public void queueOrder(StopBuyOrder order) {
        stopBuyOrderQueue.enqueue(order);
    }

    /**
     * Queue order.
     *
     * @param order the order
     */
    @Override
    public void queueOrder(StopSellOrder order) {
        stopSellOrderQueue.enqueue(order);
    }

    /**
     * Sets the buy order processor.
     *
     * @param processor the new buy order processor
     */
    @Override
    public void setBuyOrderProcessor(Consumer<StopBuyOrder> processor) {
        stopBuyOrderQueue.setConsumer(processor);
    }

    /**
     * Sets the sell order processor.
     *
     * @param processor the new sell order processor
     */
    @Override
    public void setSellOrderProcessor(Consumer<StopSellOrder> processor) {
        stopSellOrderQueue.setConsumer(processor);
    }

}
