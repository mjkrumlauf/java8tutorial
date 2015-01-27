package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

import java.util.function.Function;


public class FunctionRunnerTest implements Base {

    @Test
    public void applyFunctions() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        println(backToString.apply("123"));
    }
}
