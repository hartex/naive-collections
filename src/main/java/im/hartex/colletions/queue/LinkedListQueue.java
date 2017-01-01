package im.hartex.colletions.queue;

import im.hartex.colletions.LinkedCollectionIterator;
import im.hartex.colletions.LinkedCollectionNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple Queue data structure implementation based on Linked List
 *
 * @author hartex
 * @see im.hartex.colletions.queue.NaiveQueue
 * @see im.hartex.colletions.NaiveCollection
 */
public class LinkedListQueue<Item> implements NaiveQueue<Item> {

    // represents head and tail of the queue
    private LinkedCollectionNode<Item> head, tail;
    private int size = 0;

    @Override
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException("You are trying to enqueue null element");

        LinkedCollectionNode<Item> newTail = new LinkedCollectionNode<>(item, tail, null);
        if (tail != null)
            tail.previous = newTail;

        tail = newTail;
        size++;
        if (isEmpty())
            head = tail;
    }

    @Override
    public Item dequeue() {
        if (head == null)
            throw new NoSuchElementException("LinkedListQueue is empty");

        LinkedCollectionNode<Item> currentHead = head;
        head = currentHead.previous;
        if (isEmpty()) {
            tail = null;
        } else {
            head.next = null;
        }
        size--;
        return currentHead.item;
    }

    @Override
    public Item peek() {
        if (head == null)
            throw new NoSuchElementException("LinkedListQueue is empty");

        return head.item;
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
        return new LinkedCollectionIterator<>(head, this);
    }
}
