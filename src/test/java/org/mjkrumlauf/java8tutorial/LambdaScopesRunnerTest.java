package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

public class LambdaScopesRunnerTest {

    @Test
    public void finalLocalVariable() {
        final int num = 1;
        final Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));
    }

    @Test
    public void effectivelyFinalLocalVariable() {
        int num = 3;
        final Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(4));
    }
}
