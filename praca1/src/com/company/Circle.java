package com.company;

public class Circle extends Figure{

    public Circle(double a, double b) {
        super(a, b);
    }

    @Override
    double getArea() {
        return getA()*getA()*Math.PI;
    }

    @Override
    double getCircuit() {
        return 2*Math.PI*getA();
    }
}
