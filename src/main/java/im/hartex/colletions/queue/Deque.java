package im.hartex.colletions.queue;

import im.hartex.colletions.LinkedCollectionNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author hartex
 */
public class Deque<Item> implements Iterable<Item> {
    
    private LinkedCollectionNode<Item> first, last;

    private int size = 0;

    /**
     * Construct an empty deque
     */
    public Deque() {
    }

    /**
     * Is the deque empty?
     */
    public boolean isEmpty() {
        return first == null || last == null;
    }

    /**
     * Return the number of items on the deque
     */
    public int size() {
        int count = 0;

        if (isEmpty()) {
            return count;
        }

        LinkedCollectionNode current = last;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Add the item to the front
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        LinkedCollectionNode<Item> newFirst = new LinkedCollectionNode<>(item, null, first);
        if (first != null)
            first.next = newFirst;

        first = newFirst;
        size++;

        if (last == null)
            last = first;
    }

    /**
     * Add the item to the end
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        LinkedCollectionNode<Item> newLast = new LinkedCollectionNode<>(item, last, null);
        if (last != null)
            last.previous = newLast;

        last = newLast;
        size++;

        if (first == null)
            first = last;
    }

    /**
     * Remove and return the item from the front
     */
    public Item removeFirst() {
        if (first == null)
            throw new NoSuchElementException();

        LinkedCollectionNode<Item> currentFirst = first;
        first = currentFirst.previous;
        if (first != null) {
            first.next = null;
        } else {
            last = null;
        }

        size--;

        return currentFirst.item;
    }

    /**
     * Remove and return the item from the end
     */
    public Item removeLast() {
        if (last == null)
            throw new NoSuchElementException();

        LinkedCollectionNode<Item> currentLast = last;
        last = currentLast.next;
        if (last != null) {
            last.previous = null;
        } else {
            first = null;
        }

        size--;

        return currentLast.item;
    }

    /**
     * Return an iterator over items in order from front to end
     */
    public Iterator<Item> iterator() {
        return this.new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private LinkedCollectionNode<Item> currentLast = last;

        @Override
        public boolean hasNext() {
            return currentLast != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = currentLast.item;
            currentLast = currentLast.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }
}
