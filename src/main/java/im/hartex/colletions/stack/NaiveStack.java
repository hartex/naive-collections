package im.hartex.colletions.stack;

import im.hartex.colletions.NaiveCollection;

/**
 * A basic interface for Stack collections that are following LIFO principle
 *
 * @author hartex
 * @see NaiveCollection
 */
public interface NaiveStack<Item> extends NaiveCollection<Item>, Iterable<Item> {

    /**
     * Put a single item on top of the stack
     *
     * @param item a single element that will be placed on top of the stack
     */
    default void push(Item item) {
        if (item == null)
            throw new NullPointerException("You are trying to add null to the " + getClass().getSimpleName());
    }

    /**
     * @return a single item from the top of the stack (but doesn't remove it)
     */
    Item peek();

    /**
     * Removes a single item from the top of the stack
     *
     * @return removed item
     */
    Item pop();

}
