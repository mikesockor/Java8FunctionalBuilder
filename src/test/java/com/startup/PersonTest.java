package com.startup;

import com.startup.efficient.CoolPerson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonTest {

    @Test
    public void testSetterBuilderOneField() {

        Person person = Person.builder.get()
            .and(x -> x.withName("name"))
            .build();

        assertEquals("name", person.getName());
        assertNull(person.getLastName());
    }

    @Test
    public void testSetterBuilderTwoFields() {

        Person person1 = Person.builder.get()
            .and((x) -> x.withName("name"))
            .and((y) -> y.withLastName("last name"))
            .build();

        Person person2 = Person.builder.get()
            .and($ -> {
                $.withName("name");
                $.withLastName("last name");
            })
            .build();

        assertEquals("name", person1.getName());
        assertEquals("last name", person1.getLastName());
        assertEquals("name", person2.getName());
        assertEquals("last name", person2.getLastName());

    }

    @Test
    public void testReflectionBuilder() {

        Person person = Person.builder.get()
            .and($ -> {
                $.setField("name", "Johny");
                $.setField("lastName", "Be Good");
            })
            .build();

        assertEquals("Johny", person.getName());
        assertEquals("Be Good", person.getLastName());

    }

    @Test
    public void testReflectionEfficientBuilder() {

        CoolPerson person = CoolPerson.builder.get()
            .and($ -> {
                $.setter.accept("name", "Johny");
                $.setter.accept("lastName", "Be Good");
            })
            .build();

        assertEquals("Johny", person.getName());
        assertEquals("Be Good", person.getLastName());

    }

}

