package io.hartex.colletions.stack;

import io.hartex.colletions.LinkedCollectionNode;

/**
 * Created by hartex
 */
public class LinkedListStack<Item> implements NaiveStack<Item> {

    private LinkedCollectionNode<Item> top;

    @Override
    public void push(Item item) {
        LinkedCollectionNode<Item> newTop = new LinkedCollectionNode<Item>(item, null, top);
        top.setNext(newTop);
        top = newTop;
    }

    @Override
    public Item pop() {
        LinkedCollectionNode<Item> currentTop = top;
        top = currentTop.getPrevious();
        top.setNext(null);
        return currentTop.getItem();
    }

    @Override
    public int size() {
        int count = 0;

        if (isEmpty()) {
            return count;
        }

        LinkedCollectionNode current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
