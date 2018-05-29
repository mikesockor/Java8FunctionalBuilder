package com.startup;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Person {

    private String name;
    private String lastName;

    @Override public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }

    public static Supplier<PersonBuilder> builder = Person.PersonBuilder::new;

    public static class PersonBuilder {

        Person itself;

        public void withName(String name) {
            itself.name = name;
        }

        public void withLastName(String lastName) {
            itself.lastName = lastName;
        }

        PersonBuilder() {
            this.itself = new Person();
        }

        public PersonBuilder and(Consumer<PersonBuilder> input) {
            input.accept(this);
            return this;
        }

        public Person build() {
            return itself;
        }
    }

}

