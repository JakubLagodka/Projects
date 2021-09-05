package com.company;

public class Circle extends Figure {

    public Circle(double a, double b) {
        super(a, b);
    }

    @Override
     public double getArea() {
        return a * a * Math.PI;
    }

    @Override
     public double getCircuit() {
        return 2 * Math.PI * a;
    }
}
