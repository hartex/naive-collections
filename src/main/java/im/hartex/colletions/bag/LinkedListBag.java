package im.hartex.colletions.bag;

import im.hartex.colletions.LinkedCollectionIterator;
import im.hartex.colletions.LinkedCollectionNode;
import im.hartex.colletions.NaiveCollection;

import java.util.Iterator;

/**
 * A simple implementation of Bag based on Linked List data structure
 *
 * @author hartex
 * @see NaiveBag
 * @see NaiveCollection
 */
public class LinkedListBag<Item> implements NaiveBag<Item> {

    private LinkedCollectionNode<Item> head;
    private int size = 0;

    @Override
    public void add(Item item) {
        NaiveBag.super.add(item);
        LinkedCollectionNode<Item> newHead = new LinkedCollectionNode<>(item, null, head);
        if (head != null)
            head.next = newHead;
        head = newHead;
        size++;
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
