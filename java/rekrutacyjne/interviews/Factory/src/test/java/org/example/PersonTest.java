package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    public void shouldCreateASinglePerson() {
        Factory factory = new Factory();
        Person person = factory.createPersonWithForceIncrementalId("John", "Smith");

        Assertions.assertEquals(1,person.id());

    }
    @Test
    public void shouldCreateABunchOfPeople() {
        Factory factory = new Factory();
        Person person1 = factory.createPersonWithForceIncrementalId("John", "Smith");
        Person person2 = factory.createPersonWithForceIncrementalId("James", "May");

        Assertions.assertEquals(1,person1.id());
        Assertions.assertEquals(2,person2.id());
    }

}