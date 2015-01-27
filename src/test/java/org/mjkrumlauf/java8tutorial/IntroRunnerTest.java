package org.mjkrumlauf.java8tutorial;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntroRunnerTest implements Base {

    @Test
    public void defaultMethod() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        println(formula.calculate(100));
        println(formula.sqrt(16));
    }

    @Test
    public void collectionsLambda() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    @Test
    public void functionalInterfaceLambda() {
        Converter<String, Integer> converter1 = (from) -> Integer.valueOf(from);
        println(converter1.convert("123"));
    }

    @Test
    public void staticMethodReference() {
        Converter<String, Double> converter2 = Double::valueOf;
        println(converter2.convert("456.0"));
    }

    @Test
    public void objectMethodReference() {
        Something something = new Something();
        Converter<String, String> converter3 = something::startsWith;
        println(converter3.convert("Java"));
    }

    @Test
    public void constructorReference() {
        PersonFactory pf = Person::new;
        Person p1 = pf.create("Peter", "Parker");
        println(p1.firstName + " " + p1.lastName);
    }
}
