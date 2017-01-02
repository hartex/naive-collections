package im.hartex.colletions;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A common iterator that is used for Array based collections
 *
 * @author hartex
 * @see java.util.Iterator
 */
public class ResizingCollectionIterator<Item> implements Iterator<Item> {

    private int index;
    private Item[] items;
    private NaiveCollection<Item> collection;

    public ResizingCollectionIterator(int index, Item[] items, NaiveCollection<Item> collection) {
        this.index = index;
        this.items = items;
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public Item next() {
        int nextIndex = --index;
        if (nextIndex < 0)
            throw new NoSuchElementException(collection.getClass().getSimpleName() + " is empty");

        return items[nextIndex];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(collection.getClass().getSimpleName() + " doesn't support remove operation");
    }
}
