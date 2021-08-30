package com.company;

public class Trapeze extends Figure {

    private double h, c, d;

    public Trapeze(double a, double b, double h, double c, double d) {
        super(a, b);
        this.h = h;
        this.c = c;
        this.d = d;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getH() {
        return h;
    }

    @Override
    double getArea() {
        return (getA() + getB()) * h;
    }

    @Override
    double getCircuit() {
        return getA()+getB()+c+d;
    }
}
