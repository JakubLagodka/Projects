package org.example;

public class Product {

    private String name;

    private double dollarsValue;

    public Product(String name, double value) {
        this.name = name;
        this.dollarsValue = value;
    }

    public String getName() {
        return name;
    }

    public double getDollarsValue() {
        return dollarsValue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", dollarsValue=" + dollarsValue +
                '}';
    }
}
