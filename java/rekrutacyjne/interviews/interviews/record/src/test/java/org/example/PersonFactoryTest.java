package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonFactoryTest {

    @Test
    public void testCreateSinglePerson() {
        PersonFactory factory = new PersonFactory();
        Person person = factory.createPerson("John", "Doe");

        assertEquals(1, person.id());
        assertEquals("John", person.firstName());
        assertEquals("Doe", person.lastName());
    }

    @Test
    public void testCreateMultiplePeople() {
        PersonFactory factory = new PersonFactory();

        Person person1 = factory.createPerson("John", "Doe");
        Person person2 = factory.createPerson("Jane", "Smith");
        Person person3 = factory.createPerson("Alice", "Johnson");

        assertEquals(1, person1.id());
        assertEquals("John", person1.firstName());
        assertEquals("Doe", person1.lastName());

        assertEquals(2, person2.id());
        assertEquals("Jane", person2.firstName());
        assertEquals("Smith", person2.lastName());

        assertEquals(3, person3.id());
        assertEquals("Alice", person3.firstName());
        assertEquals("Johnson", person3.lastName());
    }
}