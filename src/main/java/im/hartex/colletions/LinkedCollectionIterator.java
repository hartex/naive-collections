package im.hartex.colletions;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A common iterator that is used for every collection that is based on Linked List
 *
 * @author hartex
 * @see java.util.Iterator
 */
public class LinkedCollectionIterator<Item> implements Iterator<Item> {

    private LinkedCollectionNode<Item> current;
    private NaiveCollection<Item> collection;

    public LinkedCollectionIterator(LinkedCollectionNode<Item> current, NaiveCollection<Item> collection) {
        this.current = current;
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        if (collection.isEmpty())
            throw new NoSuchElementException(collection.getClass().getSimpleName() + " is empty");

        Item item = current.item;
        current = current.previous;
        return item;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(collection.getClass().getSimpleName() + " doesn't support remove operation");
    }

}
