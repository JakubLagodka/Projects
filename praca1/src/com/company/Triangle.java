package com.company;

public class Triangle extends Figure {
    private double h;
    private double c;

    public Triangle(double a, double b, double c, double h) {
        super(a, b);
        this.c = c;
        this.h = h;
    }


    @Override
    public double getArea() {
        return a * h * 0.5;
    }

    @Override
    public double getCircuit() {
        return a + b + c;
    }
}
