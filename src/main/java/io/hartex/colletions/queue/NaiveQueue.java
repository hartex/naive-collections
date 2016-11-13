package io.hartex.colletions.queue;

import io.hartex.colletions.NaiveCollection;

/**
 * Created by hartex
 */
public interface NaiveQueue<Item> extends NaiveCollection<Item> {

    void enqueue(Item item);

    Item dequeue();

}
