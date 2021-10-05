package com.company;

public class B {
    static {
        System.out.println("static B");
    }

    {
        System.out.println("block B");
    }

    public B() {
        System.out.println("B");
    }

}
