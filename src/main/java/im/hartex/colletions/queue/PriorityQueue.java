package im.hartex.colletions.queue;

import java.util.Iterator;

/**
 * @author hartex
 */
public class PriorityQueue<Item extends Comparable<Item>> implements NaiveQueue<Item> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(Item item) {

    }

    @Override
    public Item dequeue() {
        return null;
    }

    @Override
    public Item peek() {
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public Item max() {
        return null;
    }

    public Item min() {
        return null;
    }

    public Item deleteMax() {
        return null;
    }

    public Item deleteMin() {
        return null;
    }
}
