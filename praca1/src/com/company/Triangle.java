package com.company;

public class Triangle extends Figure {
    private double h, c;

    public Triangle(double a, double b, double c, double h) {
        super(a, b);
        this.c = c;
        this.h = h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getH() {
        return h;
    }

    public double getC() {
        return c;
    }

    @Override
    double getArea() {
        return getA()*h*0.5;
    }

    @Override
    double getCircuit() {
        return getA()+getB()+c;
    }
}
