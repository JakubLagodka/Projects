package com.company;

public interface I {

    void iTest();

    default void defaultMethod() {
        System.out.println("default");
    }

    private void privateMethod() {
        System.out.println("private");
    }

}

