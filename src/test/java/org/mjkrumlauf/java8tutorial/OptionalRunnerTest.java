package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

import java.util.Optional;

public class OptionalRunnerTest implements Base {

    @Test
    public void run() {
        Optional<String> optional = Optional.of("value");

        println(optional.isPresent());
        println(optional.get());

        Optional<String> nullOptional = Optional.empty();
        println(nullOptional.orElse("fallback"));

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
