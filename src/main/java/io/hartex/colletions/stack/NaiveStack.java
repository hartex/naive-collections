package io.hartex.colletions.stack;

import io.hartex.colletions.NaiveCollection;

/**
 * Created by hartex
 */
public interface NaiveStack<Item> extends NaiveCollection<Item> {

    void push(Item item);

    Item pop();

}
