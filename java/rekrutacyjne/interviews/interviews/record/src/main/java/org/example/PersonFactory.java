package org.example;

public class PersonFactory {
    private int currentId;

    public PersonFactory() {
        this.currentId = 0;
    }

    public Person createPerson(String firstName, String lastName) {
        currentId++;
        return new Person(currentId, firstName, lastName);
    }
}