package io.hartex.colletions.stack;

import io.hartex.colletions.NaiveCollection;

/**
 * Created by hartex
 */
public interface NaiveStack<T> extends NaiveCollection<T> {

    void push(T item);

    T pop();

}
