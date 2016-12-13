package io.hartex.colletions.stack;

import io.hartex.colletions.LinkedCollectionNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of Stack based on Linked List data structure
 *
 * @author hartex
 * @see io.hartex.colletions.stack.NaiveStack
 * @see io.hartex.colletions.NaiveCollection
 */
public class LinkedListStack<Item> implements NaiveStack<Item> {

    private LinkedCollectionNode<Item> top;
    private int size = 0;

    @Override
    public void push(Item item) {
        LinkedCollectionNode<Item> newTop = new LinkedCollectionNode<Item>(item, null, top);
        if (top != null)
            top.next = newTop;
        top = newTop;
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedListStack is empty");

        LinkedCollectionNode<Item> currentTop = top;
        top = currentTop.previous;
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
        return new Iterator<Item>() {

            private LinkedCollectionNode<Item> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (isEmpty())
                    throw new NoSuchElementException("LinkedListStack is empty");

                Item item = current.item;
                current = current.previous;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("LinkedListStack doesn't support remove operation");
            }
        };
    }
}
