package org.mjkrumlauf.java8tutorial;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
