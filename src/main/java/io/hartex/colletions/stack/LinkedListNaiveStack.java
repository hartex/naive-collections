package io.hartex.colletions.stack;

/**
 * Created by hartex
 */
public class LinkedListNaiveStack<T> implements NaiveStack<T> {

    private Node top;

    @Override
    public void push(T item) {
        top = new Node(item, top);
    }

    @Override
    public T pop() {
        Node currentTop = top;
        top = currentTop.getNext();
        return currentTop.getItem();
    }

    @Override
    public int size() {
        int count = 0;

        if (isEmpty()) {
            return count;
        }

        Node current = top;
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

    private class Node {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        T getItem() {
            return item;
        }

        Node getNext() {
            return next;
        }
    }
}
