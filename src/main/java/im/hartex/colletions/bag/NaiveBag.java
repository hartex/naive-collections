package im.hartex.colletions.bag;

import im.hartex.colletions.NaiveCollection;

/**
 * A basic interface to Bag collections
 *
 * @author hartex
 * @see NaiveCollection
 */
public interface NaiveBag<Item> extends NaiveCollection<Item>, Iterable<Item> {

    /**
     * Adds new item to the Bag
     *
     * @param item to add
     */
    default void add(Item item) {
        if (item == null)
            throw new NullPointerException("You are trying to add null to the " + getClass().getSimpleName());
    }
}
