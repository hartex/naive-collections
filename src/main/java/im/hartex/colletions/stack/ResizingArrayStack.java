package im.hartex.colletions.stack;

import im.hartex.colletions.NaiveCollection;
import im.hartex.colletions.ResizingCollectionIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Stack that is using array and
 * {@link System#arraycopy(java.lang.Object, int, java.lang.Object, int, int) System.arraycopy}
 * (for resizing) under the hood
 *
 * @author hartex
 * @see NaiveStack
 * @see NaiveCollection
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
        NaiveStack.super.push(item);
        if (pointerIndex == items.length)
            resize(2 * items.length);
        items[pointerIndex++] = item;
    }

    @Override
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("ResizingArrayStack is empty");

        return items[pointerIndex - 1];
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
        return new ResizingCollectionIterator<>(pointerIndex, items, this);
    }
}