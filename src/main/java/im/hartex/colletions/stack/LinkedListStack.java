package im.hartex.colletions.stack;

import im.hartex.colletions.LinkedCollectionIterator;
import im.hartex.colletions.LinkedCollectionNode;
import im.hartex.colletions.NaiveCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Stack based on Linked List data structure
 *
 * @author hartex
 * @see NaiveStack
 * @see NaiveCollection
 */
public class LinkedListStack<Item> implements NaiveStack<Item> {

    private LinkedCollectionNode<Item> top;
    private int size = 0;

    @Override
    public void push(Item item) {
        NaiveStack.super.push(item);
        LinkedCollectionNode<Item> newTop = new LinkedCollectionNode<>(item, null, top);
        if (top != null)
            top.next = newTop;
        top = newTop;
        size++;
    }

    @Override
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedListStack is empty");

        return top.item;
    }

    @Override
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedListStack is empty");

        LinkedCollectionNode<Item> currentTop = top;
        top = currentTop.previous;

        if (top != null)
            top.next = null;

        size--;
        return currentTop.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedCollectionIterator<>(top, this);
    }
}
