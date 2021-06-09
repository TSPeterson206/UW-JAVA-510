package edu.uw.broker;

import java.util.Comparator;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
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
public class SimpleOrderQueue<T, E extends Order>
    implements OrderQueue<T, E>, Runnable {

    /** The consumer. */
    private Consumer<E> consumer;

    /** The threshold. */
    private T threshold;

    /** The filter. */
    private BiPredicate<T, E> filter;

    /** The queue. */
    private TreeSet<E> queue;

    /** The dispatch thread. */
    private Thread dispatchThread;

    /** The processor lock. */
    private ReentrantLock consumerLock = new ReentrantLock();

    /** The queue lock. */
    private ReentrantLock queueLock = new ReentrantLock();

    /** The dispatch condition. */
    private Condition cond = queueLock.newCondition();

    /**
     * Instantiates a new simple order queue.
     *
     * @param threshold the threshold
     * @param filter    the filter
     * @param cmp       the cmp
     * @param name      the name
     */
    public SimpleOrderQueue(T threshold, BiPredicate<T, E> filter,
        Comparator<E> cmp, String name) {
        queue = new TreeSet<>(cmp);
        this.threshold = threshold;
        this.filter = filter;
        startDispatchThread(name);
    };

    /**
     * Instantiates a new simple order queue.
     *
     * @param threshold the threshold
     * @param filter    the filter
     * @param name      the name
     */
    public SimpleOrderQueue(T threshold, BiPredicate<T, E> filter,
        String name) {
        // Thanks for the naturalOrder explanation. I like this touch.
        this(threshold, filter, Comparator.naturalOrder(), name);
    };

    /**
     * Sets the priority.
     *
     * @param priority the new priority
     */
    public void setPriority(int priority) {
        dispatchThread.setPriority(priority);
    };

    /**
     * Start dispatch thread.
     *
     * @param name the name
     */
    private void startDispatchThread(String name) {
        dispatchThread = new Thread(this, name + "-dispatchthread");
        dispatchThread.setDaemon(true);
        dispatchThread.start();
    }

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
        consumerLock.lock();
        try {
            this.consumer = consumer;
        } finally {
            consumerLock.unlock();
        }
    }

    /**
     * Sets the threshold.
     *
     * @param threshold the new threshold
     */
    @Override
    public void setThreshold(T threshold) {
        this.threshold = threshold;
        dispatchOrders();
    }

    /**
     * The enqueue method.
     *
     * @param order The order passed in.
     */
    @Override
    public void enqueue(E order) {
        queueLock.lock();
        try {
            queue.add(order);
            dispatchOrders();
        } finally {
            queueLock.unlock();
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
        queueLock.lock();
        try {
            if (!queue.isEmpty()) {
                dispatchable = queue.first();
                if (filter != null && filter.test(threshold, dispatchable)) {
                    queue.remove(dispatchable);
                } else {
                    dispatchable = null;
                }
            }
        } finally {
            queueLock.unlock();
        }
        return Optional.<E>ofNullable(dispatchable);
    }

    /**
     * Dispatch orders.
     */
    public void dispatchOrders() {
        queueLock.lock();
        try {
            cond.signal();
        } finally {
            queueLock.unlock();
        }
    }

    /**
     * The run method for the now threaded SimpleOrderQueue class.
     */
    @Override
    public void run() {
        while (true) {
            Optional<E> optional;
            queueLock.lock();
            try {
                while (!(optional = dequeue()).isPresent()) {
                    try {
                        cond.await();
                    } catch (InterruptedException exc) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } finally {
                queueLock.unlock();
            }

            consumerLock.lock();
            try {
                if (consumer != null) {
                    consumer.accept(optional.get());
                }
            } finally {
                consumerLock.unlock();
            }
        }
    }
}
