package edu.uw.broker;

import java.util.Comparator;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import edu.uw.ext.framework.broker.OrderQueue;
import edu.uw.ext.framework.order.Order;

/**
 * The Class SimpleOrderQueue.
 *
 * @param <T> the generic type
 * @param <E> the element type
 */
public class SimpleOrderQueue<T, E extends Order> implements OrderQueue<T, E> {

    /** The consumer. */
    public Consumer<E> consumer;

    /** The threshold. */
    public T threshold;

    /** The filter. */
    public BiPredicate<T, E> filter;

    /** The queue. */
    public TreeSet<E> queue;

    /**
     * Instantiates a new simple order queue.
     *
     * @param threshold The threshold passed in.
     * @param filter    The filter passed in
     * @param cmp       The comparator passed in.
     */
    public SimpleOrderQueue(T threshold, BiPredicate<T, E> filter,
        Comparator<E> cmp) {
        queue = new TreeSet<>(cmp);
        this.threshold = threshold;
        this.filter = filter;
    };

    /**
     * Instantiates a new simple order queue.
     *
     * @param threshold the threshold
     * @param filter    the filter
     */
    public SimpleOrderQueue(T threshold, BiPredicate<T, E> filter) {
        // Thanks for the naturalOrder explanation. I like this touch.
        this(threshold, filter, Comparator.naturalOrder());
    };

    /**
     * The getThreshold method. Grabs the current threshold.
     *
     * @return T the threshold.
     */
    @Override
    public T getThreshold() {
        return threshold;
    }

    /**
     * Sets the consumer.
     *
     * @param consumer the new consumer
     */
    @Override
    public void setConsumer(Consumer<E> consumer) {
        this.consumer = consumer;

    }

    /**
     * Sets the threshold.
     *
     * @param threshold the new threshold
     */
    @Override
    public void setThreshold(T threshold) {
        this.threshold = threshold;
        Optional<E> optional;
        while ((optional = dequeue()).isPresent()) {
            if (consumer != null) {
                consumer.accept(optional.get());
            }
        }
    }

    /**
     * The enqueue method.
     *
     * @param order The order passed in.
     */
    @Override
    public void enqueue(E order) {
        queue.add(order);
        Optional<E> optional;
        while ((optional = dequeue()).isPresent()) {
            if (consumer != null) {
                consumer.accept(optional.get());
            }
        }
    }

    /**
     * The dequeue method.
     *
     * @return the optional.
     */
    @Override
    public Optional<E> dequeue() {
        E dispatchable = null;

        if (!queue.isEmpty()) {
            dispatchable = queue.first();
            if (filter.test(threshold, dispatchable)) {
                queue.remove(dispatchable);
            } else {
                dispatchable = null;
            }
        }
        return Optional.<E>ofNullable(dispatchable);
    }
}
