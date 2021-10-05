package com.company;

public class Test {

    static {
        System.out.println("static block Test");
    }

    {
        System.out.println("block Test");
    }

    public Test() {
        System.out.println("Test");
    }

}
