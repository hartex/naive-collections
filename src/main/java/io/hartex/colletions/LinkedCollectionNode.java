package io.hartex.colletions;

/**
 * Created by hartex
 */
public class LinkedCollectionNode<Item> {

    private Item item;
    private LinkedCollectionNode<Item> next;
    private LinkedCollectionNode<Item> previous;

    public LinkedCollectionNode(Item item) {
        this.item = item;
        this.next = this;
        this.previous = this;
    }

    public LinkedCollectionNode(Item item, LinkedCollectionNode<Item> next, LinkedCollectionNode<Item> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LinkedCollectionNode<Item> getNext() {
        return next;
    }

    public void setNext(LinkedCollectionNode<Item> next) {
        this.next = next;
    }

    public LinkedCollectionNode<Item> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedCollectionNode<Item> previous) {
        this.previous = previous;
    }
}

