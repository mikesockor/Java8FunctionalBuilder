package com.startup;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class Person {

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public static Supplier<PersonBuilder> builder = Person.PersonBuilder::new;

    public static class PersonBuilder {

        Person itself;

        // imperative kinda setters
        public void withName(String name) {
            itself.name = name;
        }

        // imperative kinda setters
        public void withLastName(String lastName) {
            itself.lastName = lastName;
        }

        // reflection way
        public void setField(String fieldName, Object object) {
            try {
                Class classOf = itself.getClass();
                Field field = classOf.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(itself, object);
                field.setAccessible(false);
            }
            catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
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

