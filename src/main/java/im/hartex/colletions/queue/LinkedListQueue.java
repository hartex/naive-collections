package im.hartex.colletions.queue;

import im.hartex.colletions.LinkedCollectionNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple Queue data structure implementation based on Linked List
 *
 * @author hartex
 */
public class LinkedListQueue<Item> implements NaiveQueue<Item> {

    // represents head and tail of the queue
    private LinkedCollectionNode<Item> head, tail;
    private int size = 0;

    @Override
    public void enqueue(Item item) {
        LinkedCollectionNode<Item> newLast = new LinkedCollectionNode<>(item, tail, null);
        if (tail != null)
            tail.previous = newLast;

        tail = newLast;
        size++;
        if (isEmpty())
            head = tail;
    }

    @Override
    public Item dequeue() {
        if (head == null)
            throw new NoSuchElementException("LinkedListQueue is empty");

        LinkedCollectionNode<Item> firstNode = head;
        head = firstNode.previous;
        if (isEmpty()) tail = null;
        size--;
        return firstNode.item;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("LinkedListQueue doesn't support remove operation");
            }
        };
    }
}
