package com.company;

public class B2 implements I {

    public void method() {
        System.out.println("method b2");
    }

    @Override
    public void iTest() {
        System.out.println("I from B2");
    }

}