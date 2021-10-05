package com.company;

public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public Fraction add(Fraction toAdd) {

        bringToCommonDenominator(toAdd);

        this.numerator += toAdd.numerator;
        shorten();
        return this;
    }

    public Fraction subtract(Fraction toSubtract) {

        bringToCommonDenominator(toSubtract);

        this.numerator -= toSubtract.numerator;
        shorten();
        return this;
    }

    public Fraction multiply(Fraction toMultiply) {

        this.numerator *= toMultiply.numerator;
        this.denominator *= toMultiply.denominator;
        shorten();
        return this;
    }

    public Fraction divide(Fraction toDivide) {

        this.numerator *= toDivide.denominator;
        this.denominator *= toDivide.numerator;
        shorten();
        return this;
    }

    public Fraction shorten() {

        for (int i = this.numerator; i > 1; i--) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                this.numerator /= i;
                this.denominator /= i;
                break;
            }
        }
        return this;
    }

    public Fraction bringToCommonDenominator(Fraction second) {
        if (this.denominator != second.denominator) {
            //NNW

            for (int i = this.denominator; ; i += this.denominator) {
                if (i % second.denominator == 0) {
                    int tmp = i / this.denominator;
                    this.denominator = i;
                    this.numerator *= tmp;
                    tmp = i / second.denominator;
                    second.numerator *= tmp;
                    second.denominator = i;
                    break;
                }
            }
        }
        return this;
    }

    public double decimalNotation() {
        return (double) this.numerator / (double) this.denominator;
    }

    public Fraction exponentiate(int exponent) {

        this.numerator = (int) Math.pow(this.numerator, exponent);
        this.denominator = (int) Math.pow(this.denominator, exponent);
        shorten();
        return this;
    }

    public Fraction root() {

        this.numerator = (int) Math.sqrt(this.numerator);
        this.denominator = (int) Math.sqrt(this.denominator);
        shorten();
        return this;
    }


    @Override
    public String toString() {
        return "Ułamek{" +
                "licznik=" + numerator +
                ", mianownik=" + denominator +
                '}';
    }

    @Override
    public int compareTo(Fraction o) {
        if (this.decimalNotation() > o.decimalNotation())
            return 1;
        else if (this.decimalNotation() == o.decimalNotation())
            return 0;
        else return -1;
    }
}
