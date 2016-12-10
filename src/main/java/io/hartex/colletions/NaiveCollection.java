package io.hartex.colletions;

/**
 * A basic interface for all collections implemented in this library
 *
 * @author hartex
 */
public interface NaiveCollection<Item> {

    /**
     * @return a number of elements that collection contains
     */
    int size();

    /**
     * @return false if collection contains 0 elements, and true otherwise
     */
    boolean isEmpty();

    // todo consider adding this
    // boolean contains(Item item);
}
