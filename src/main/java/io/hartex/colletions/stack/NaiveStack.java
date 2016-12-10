package io.hartex.colletions.stack;

import io.hartex.colletions.NaiveCollection;

/**
 * A basic interface for Stack collections that are following LIFO principle
 *
 * @author hartex
 * @see io.hartex.colletions.NaiveCollection
 */
public interface NaiveStack<Item> extends NaiveCollection<Item>, Iterable<Item> {

    /**
     * Put a single item on top of the stack
     *
     * @param item a single element that will be placed on top of the stack
     */
    void push(Item item);

    /**
     * Removes a single item from the top of the stack
     *
     * @return removed item
     */
    Item pop();

}
