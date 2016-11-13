package io.hartex.colletions.stack;

/**
 * Created by hartex
 */
@SuppressWarnings("unchecked")
public class ResizingArrayStack<Item> implements NaiveStack<Item> {

    private Item[] items;
    private int pointerIndex = 0;

    public ResizingArrayStack() {
        this(10);
    }

    public ResizingArrayStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    @Override
    public void push(Item item) {
        if (pointerIndex == items.length)
            resize(2 * items.length);
        items[pointerIndex++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--pointerIndex];
        items[pointerIndex] = null;
        if (pointerIndex > 0 && pointerIndex == items.length / 4)
            resize(items.length / 2);
        return item;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return pointerIndex == 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, pointerIndex);
        items = copy;
    }
}