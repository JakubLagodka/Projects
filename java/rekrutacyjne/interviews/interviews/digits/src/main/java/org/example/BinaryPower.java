package org.example;

public class BinaryPower {
    public static void main(String[] args) {
        double number = 2;
        int powerty = 0;
        double expresion = 0;
        while (expresion < Double.MAX_VALUE) {
            expresion = Math.pow(number, powerty);
            powerty++;
            System.out.println(powerty + " | " + expresion);
        }
    }
}
