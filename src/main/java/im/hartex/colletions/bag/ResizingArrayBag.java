package im.hartex.colletions.bag;

import im.hartex.colletions.NaiveCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Bag that is using array and
 * {@link System#arraycopy(java.lang.Object, int, java.lang.Object, int, int) System.arraycopy}
 * (for resizing) under the hood
 *
 * @author hartex
 * @see NaiveBag
 * @see NaiveCollection
 */
public class ResizingArrayBag<Item> implements NaiveBag<Item> {

    private Item[] items;
    private int pointerIndex = 0;

    /**
     * Creates an empty bag with default capacity of 15
     */
    public ResizingArrayBag() {
        this(15);
    }

    /**
     * Creates an empty bag with specified size
     *
     * @param capacity initial size of the bag
     */
    @SuppressWarnings("unchecked")
    public ResizingArrayBag(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    @Override
    public void add(Item item) {
        NaiveBag.super.add(item);
        if (pointerIndex == items.length)
            resize(2 * items.length);
        items[pointerIndex++] = item;
    }

    @Override
    public int size() {
        return pointerIndex;
    }

    @Override
    public boolean isEmpty() {
        return pointerIndex == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Item[] copy = (Item[]) new Object[newCapacity];
        System.arraycopy(items, 0, copy, 0, pointerIndex);
        items = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int index = pointerIndex;

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public Item next() {
                int nextIndex = --index;
                if (nextIndex < 0)
                    throw new NoSuchElementException("ResizingArrayBag is empty");

                return items[nextIndex];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("ResizingArrayBag doesn't support remove operation");
            }
        };
    }
}
