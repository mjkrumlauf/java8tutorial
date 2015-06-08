package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamsRunnerTest implements Base {

    private final List<String> stringCollection;
    private final List<String> values;

    public StreamsRunnerTest() {
        this.stringCollection = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

        final int max = 1_000_000;
        this.values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    @Test
    public void sort() {
        streamSort(this.values.stream(), "Sequential");
        streamSort(this.values.parallelStream(), "Parallel");
    }

    @Test
    public void filter() {
        this.stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(this::println);
    }

    @Test
    public void filterSorted() {
        this.stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(this::println);
    }

    @Test
    public void map() {
        this.stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> a.compareTo(b))
                .forEach(this::println);
    }

    @Test
    public void match() {
        boolean anyStartsWithA =
                this.stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        println(anyStartsWithA);

        boolean allStartWithA =
                this.stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        println(allStartWithA);

        boolean noneStartWithZ =
                this.stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        println(noneStartWithZ);
    }

    @Test
    public void count() {
        long startsWithB =
                this.stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        println(startsWithB);
    }

    @Test
    public void reduce() {
        Optional<String> reduced =
                this.stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(this::println);
    }

    private void streamSort(Stream stream, String sortType) {
        long t0 = System.nanoTime();

        long count = stream.sorted().count();
        println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        println(String.format("%s sort took %d ms", sortType, millis));
    }
}
