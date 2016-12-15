package im.hartex.colletions.bag;

import im.hartex.colletions.NaiveCollection;

/**
 * Created by hartex
 */
public interface NaiveBag<Item> extends NaiveCollection<Item>, Iterable<Item> {

    void add(Item item);

}
