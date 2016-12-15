package im.hartex.colletions;

/**
 * A common class that represents a single node in linked collection
 * <p>
 * I'm not following standard POJO pattern here (with setters and getters) cause
 * I think it's overkill in that particular case
 *
 * @author hartex
 */
public class LinkedCollectionNode<Item> {

    public Item item;
    public LinkedCollectionNode<Item> next;
    public LinkedCollectionNode<Item> previous;

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

}

