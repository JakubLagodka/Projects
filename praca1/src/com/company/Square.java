package com.company;

public class Square extends Figure {
    public Square(double a, double b) {
        super(a, b);
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getCircuit() {
        return 2 * a + 2 * b;
    }
}
