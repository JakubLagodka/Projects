package com.company;

public class Square extends Figure{
    public Square(double a, double b) {
        super(a, b);
    }

    @Override
    double getArea() {
        return getA()*getB();
    }

    @Override
    double getCircuit() {
        return 2*getA()+2*getB();
    }
}
