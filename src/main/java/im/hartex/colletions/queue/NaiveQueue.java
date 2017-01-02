package im.hartex.colletions.queue;

import im.hartex.colletions.NaiveCollection;

/**
 * A basic interface for Queue collections that are following FIFO principle
 *
 * @author hartex
 * @see NaiveCollection
 */
public interface NaiveQueue<Item> extends NaiveCollection<Item>, Iterable<Item> {

    /**
     * Adds new item at the end of the queue
     *
     * @param item to add
     */
    default void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException("You are trying to add null to the " + getClass().getSimpleName());
    }

    /**
     * Removes an item from the top of the queue
     *
     * @return removed item
     */
    Item dequeue();

    /**
     * @return an item from the top of the queue (but doesn't remove it)
     */
    Item peek();

}
