package com.company;

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
        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = 127;
        Integer i4 = 127;
        Integer i5 = new Integer(128);
        Integer i6 = new Integer(128);
        Integer i7 = -128;
        Integer i8 = -128;
        System.out.println((i1 == i2) + " " + (i3 == i4) + " " + (i5 == i1) + " " + (i6 	== i4) + " " + (i5 == i6) + " " + (i7 == i8));
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

        method(1,2);
        int tab[] = {3};
        method(tab);
        int tab2[] = {4,5};
        method(1,tab2);



    }
}
