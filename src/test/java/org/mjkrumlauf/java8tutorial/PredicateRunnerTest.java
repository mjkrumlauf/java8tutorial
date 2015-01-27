package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;


public class PredicateRunnerTest implements Base {

    @Test
    public void run() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        println(predicate.test("foo"));
        println(predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        println(nonNull.test(predicate == null));

        Predicate<Boolean> isNull = Objects::isNull;
        println(isNull.test(predicate == null));
    }
}
