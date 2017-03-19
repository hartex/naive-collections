package im.hartex.colletions.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author hartex
 */
public class RandomizedQueue<Item> implements NaiveQueue<Item> {

    private Item[] items;
    private int headPointer = 0;       // index of headPointer element of queue
    private int tailPointer = 0;       // index of next available slot
    private int size = 0;

    private Random random;    // pseudo-random number generator

    /**
     * Construct an empty RandomizedQueue
     */
    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        this(10);
    }

    /**
     * Construct an empty RandomizedQueue with specified capacity
     *
     * @param capacity initial volume
     */
    @SuppressWarnings("unchecked")
    public RandomizedQueue(int capacity) {
        items = (Item[]) new Object[capacity];
        random = new Random(System.currentTimeMillis());
    }

    private RandomizedQueue(RandomizedQueue<Item> another) {
        this.items = another.items;
        this.size = another.size;
        this.headPointer = another.headPointer;
        this.tailPointer = another.tailPointer;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(Item item) {
        NaiveQueue.super.enqueue(item);
        // double size of array if necessary and recopy to front of array
        if (tailPointer == items.length)
            resize(2 * items.length);
        items[tailPointer++] = item;

        if (tailPointer == items.length)
            tailPointer = 0;          // wrap-around
        size++;
    }

    /**
     * Remove and return a random item
     */
    public Item dequeue() {
        NaiveQueue.super.dequeue();

        int randomIndex = random.nextInt(size) + headPointer;

        Item value = items[randomIndex];
        items[randomIndex] = null;     // to avoid loitering

        if (randomIndex == headPointer) {
            headPointer++;
        } else if (randomIndex == tailPointer - 1) {
            tailPointer--;
        } else {
            tailPointer--;
            System.arraycopy(items, randomIndex + 1, items, randomIndex, tailPointer - randomIndex);
            items[tailPointer] = null;
        }

        size--;

        if (headPointer == items.length)
            headPointer = 0;           // wrap-around

        // shrink size of array if necessary
        if (size > 0 && size == items.length / 4)
            resize(items.length / 2);

        return value;
    }

    @Override
    public Item peek() {
        NaiveQueue.super.peek();

        return null;
    }

    /**
     * Return (but do not remove) a random item
     */
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        int randomIndex = random.nextInt(size);
        return items[headPointer + randomIndex];
    }

    @SuppressWarnings("unchecked")
    // double size of array and recopy to front of array
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = items[(headPointer + i) % items.length];
        }
        items = temp;
        headPointer = 0;
        tailPointer = size;
    }

    /**
     * Return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private RandomizedQueue<Item> queueCopy = new RandomizedQueue<>(RandomizedQueue.this);

        @Override
        public boolean hasNext() {
            return queueCopy.size > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            return queueCopy.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
