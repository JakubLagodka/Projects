package com.company;

public class Trapeze extends Figure {

    private double h;
    private double c;
    private double d;

    public Trapeze(double a, double b, double h, double c, double d) {
        super(a, b);
        this.h = h;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getArea() {
        return (a + b) * h;
    }

    @Override
    public double getCircuit() {
        return a + b + c + d;
    }
}
