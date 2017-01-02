package im.hartex.colletions.queue;

import im.hartex.colletions.NaiveCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Queue that is using array and
 * {@link System#arraycopy(java.lang.Object, int, java.lang.Object, int, int) System.arraycopy}
 * (for resizing) under the hood
 *
 * @author hartex
 * @see NaiveQueue
 * @see NaiveCollection
 */
public class ResizingArrayQueue<Item> implements NaiveQueue<Item> {

    private Item[] items;
    private int headPointer = 0;
    private int tailPointer = 0;

    /**
     * Creates an empty queue with default capacity of 15
     */
    public ResizingArrayQueue() {
        this(15);
    }

    /**
     * Creates an empty queue with specified size
     *
     * @param capacity initial size of the queue
     */
    @SuppressWarnings("unchecked")
    public ResizingArrayQueue(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    @Override
    public void enqueue(Item item) {
        NaiveQueue.super.enqueue(item);
        if (tailPointer == items.length)
            resize(2 * items.length);
        items[tailPointer++] = item;
    }

    @Override
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("ResizingArrayQueue is empty");

        Item item = items[headPointer];
        items[headPointer] = null;
        headPointer++;

        if (tailPointer > 0 && tailPointer == items.length / 4)
            resize(items.length / 2);

        if (headPointer > 15)
            shift();

        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("ResizingArrayQueue is empty");

        return items[headPointer];
    }

    @Override
    public int size() {
        return tailPointer - headPointer;
    }

    @Override
    public boolean isEmpty() {
        return tailPointer - headPointer == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Item[] copy = (Item[]) new Object[newCapacity];
        System.arraycopy(items, 0, copy, 0, tailPointer);
        items = copy;
    }

    @SuppressWarnings("unchecked")
    private void shift() {
        Item[] copy = (Item[]) new Object[tailPointer];
        System.arraycopy(items, headPointer, copy, 0, size());
        tailPointer = tailPointer - headPointer;
        headPointer = 0;
        items = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private int headIndex = headPointer;
            private int tailIndex = tailPointer;

            @Override
            public boolean hasNext() {
                return tailIndex - headIndex > 0;
            }

            @Override
            public Item next() {
                if (headIndex == tailIndex)
                    throw new NoSuchElementException("ResizingArrayQueue is empty");

                return items[headIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("ResizingArrayQueue doesn't support remove operation");
            }
        };
    }
}
