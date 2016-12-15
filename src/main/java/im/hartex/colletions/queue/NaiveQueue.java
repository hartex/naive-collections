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
     * @param item to add
     * */
    void enqueue(Item item);

    /**
     * Removes an item from the top of the queue
     * @return removed item
     * */
    Item dequeue();

}
