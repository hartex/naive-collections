package io.hartex.colletions.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Stack that is using array and
 * {@link System#arraycopy(java.lang.Object, int, java.lang.Object, int, int) System.arraycopy}
 * (for resizing) under the hood
 *
 * @author hartex
 * @see io.hartex.colletions.stack.NaiveStack
 * @see io.hartex.colletions.NaiveCollection
 */
public class ResizingArrayStack<Item> implements NaiveStack<Item> {

    private Item[] items;
    private int pointerIndex = 0;

    /**
     * Creates an empty stack with default capacity of 15
     */
    public ResizingArrayStack() {
        this(15);
    }

    /**
     * Creates an empty stack with specified size
     *
     * @param capacity initial size of the stack
     */
    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    @Override
    public void push(Item item) {
        if (pointerIndex == items.length)
            resize(2 * items.length);
        items[pointerIndex++] = item;
    }

    @Override
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("ResizingArrayStack is empty");

        Item item = items[--pointerIndex];
        items[pointerIndex] = null;
        if (pointerIndex > 0 && pointerIndex == items.length / 4)
            resize(items.length / 2);
        return item;
    }

    @Override
    public int size() {
        return items.length;
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
                    throw new NoSuchElementException("ResizingArrayStack is empty");

                return items[nextIndex];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("ResizingArrayStack doesn't support remove operation");
            }
        };
    }
}