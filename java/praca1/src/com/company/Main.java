package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void method(int a, int... b) {
        System.out.println("int a, int... b");
    }

    public static void method(int... a) {
        System.out.println("int... a");
    }

    public static void method(int a, int b) {
        System.out.println("int a, int b");
    }

    public static void main(String[] args) {
       /* Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 127;
        Integer i4 = 127;
        Integer i5 = new Integer(128);
        Integer i6 = new Integer(128);
        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println((i1 == i2) + " " + (i3 == i4) + " " + (i5 == i1) + " " + (i6 == i4) + " " + (i5 == i6) + " " + (i7 == i8));
        //false false false false false false

        System.out.println(i1.equals(i2) + " " + i3.equals(i4) + " " + i5.equals(i1) + " 	" + i6.equals(i4));

        String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test");
        System.out.println((s1 == s2) + " " + (s2 == s3));

        System.out.println(s1.equals(s2) + " " + s2.equals(s3));

        Test t = new Test();
        Test t1 = new Test();
        A a = new A();
        B b = new B();
        B c = new A();
        C c1 = new C();
        c1.method();
        D d = new D();
        d.method();
        D d1 = new C();
        d1.method();

        method(1, 2);
        int tab[] = {3};
        method(tab);
        int tab2[] = {4, 5};
        method(1, tab2);

        A2 a2 = new A2();
        a2.method();
        a2.iTest();
        B2 b2 = new B2();
        b2.method();
        b2.iTest();
        B2 c2 = new A2();
        c2.method();
        c2.iTest();
        I i = new A2();
        //i.method();//jest źle nie wiem czy to moja wina!
        i.iTest();
        I j = new B2();
        //j.method();//jest źle nie wiem czy to moja wina!
        j.iTest();

        Figure trapeze = new Trapeze(1, 2, 3, 4, 5);
        Figure triangle = new Triangle(1, 2, 3, 4);
        Figure square = new Square(1, 2);
        Figure circle = new Circle(1, 2);
        System.out.println(trapeze.getArea() + ", " + trapeze.getCircuit());
        System.out.println(triangle.getArea() + ", " + triangle.getCircuit());
        System.out.println(square.getArea() + ", " + square.getCircuit());
        System.out.println(circle.getArea() + ", " + circle.getCircuit());/*

        */
        AA a1 = new AA();
        AA a2 = new AA();

        System.out.println((a1 == a2));

        System.out.println((a1.equals(a2)));
    }
}
