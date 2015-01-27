package org.mjkrumlauf.java8tutorial;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumerRunnerTest implements Base {

    @Test
    public void supplier() {
        Supplier<Person> personSupplier = Person::new;
        println(personSupplier.get());
    }

    @Test
    public void consumer() {
        Consumer<Person> greeter = (p) -> println("Hello, " + p);
        greeter.accept(new Person("Charles", "Spurgeon"));
    }

    @Test
    public void comparator() {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("Joe", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        println(comparator.compare(p1, p2));
        println(comparator.reversed().compare(p1, p2));
    }
}
