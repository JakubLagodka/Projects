package com.company;


public abstract class Figure {
    private double a, b;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Figure(double a, double b) {
        this.a = a;
        this.b = b;
    }

    abstract double getArea();

    abstract double getCircuit();
}
