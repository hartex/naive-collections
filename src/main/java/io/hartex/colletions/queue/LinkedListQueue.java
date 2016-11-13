package io.hartex.colletions.queue;

import io.hartex.colletions.LinkedCollectionNode;

/**
 * Created by hartex
 */
public class LinkedListQueue<Item> implements NaiveQueue<Item> {

    private LinkedCollectionNode<Item> first, last;

    @Override
    public void enqueue(Item item) {
        LinkedCollectionNode<Item> newLast = new LinkedCollectionNode<Item>(item, last, null);
        if (last != null)
            last.setPrevious(newLast);

        last = newLast;

        if (isEmpty())
            first = last;
    }

    @Override
    public Item dequeue() {
        if (first == null) {
            return null;
        } else {
            LinkedCollectionNode<Item> firstNode = first;
            first = firstNode.getPrevious();
            if (isEmpty()) last = null;
            return firstNode.getItem();
        }
    }

    @Override
    public int size() {
        int count = 0;

        if (isEmpty()) {
            return count;
        }

        LinkedCollectionNode<Item> current = last;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

}
