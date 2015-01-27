package org.mjkrumlauf.java8tutorial;


public class Person {
    final String firstName;
    final String lastName;

    Person() {
        this.firstName = "firstName";
        this.lastName = "lastName";
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void say() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
