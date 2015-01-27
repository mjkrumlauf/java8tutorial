package org.mjkrumlauf.java8tutorial;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

public interface Base {
    default <T> void println(T... data) {
        List<T> list = Arrays.asList(data);
        list.forEach(out::println);
    }
}
