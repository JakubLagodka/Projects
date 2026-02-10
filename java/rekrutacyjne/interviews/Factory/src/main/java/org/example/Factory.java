package org.example;

public class Factory {
    private int currentId;

    public Person createPersonWithForceIncrementalId(String firstName, String lastName){
        currentId++;
        return new Person(currentId,firstName,lastName);
    }
}
