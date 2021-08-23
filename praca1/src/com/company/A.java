package com.company;

public class A extends B{
    static {
        System.out.println("static A");
    }
    {
        System.out.println("block A");
    }

    public A() {
        super();
        System.out.println("A");
    }
}
