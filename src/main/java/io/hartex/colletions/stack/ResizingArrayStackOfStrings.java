package io.hartex.colletions.stack;

/**
 * Created by hartex
 */
public class ResizingArrayStackOfStrings implements NaiveStack<String> {

    private String[] items;
    private int pointerIndex = 0;

    public ResizingArrayStackOfStrings() {
        this(10);
    }

    public ResizingArrayStackOfStrings(int capacity) {
        items = new String[capacity];
    }

    @Override
    public void push(String item) {
        if (pointerIndex == items.length)
            resize(2 * items.length);
        items[pointerIndex++] = item;
    }

    @Override
    public String pop() {
        String item = items[--pointerIndex];
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
        String[] copy = new String[capacity];
        System.arraycopy(items, 0, copy, 0, pointerIndex);
        items = copy;
    }
}