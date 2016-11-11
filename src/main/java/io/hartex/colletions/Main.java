package io.hartex.colletions;

import io.hartex.colletions.stack.ResizingArrayStackOfStrings;
import io.hartex.colletions.stack.NaiveStack;

/**
 * Created by hartex
 */
public class Main {
    public static void main(String[] args) {
        NaiveStack<String> n = new ResizingArrayStackOfStrings();
        n.push("sdsd");
        n.push("sdssdfd");
        n.pop();
        System.out.println("hi");
    }
}
