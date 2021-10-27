package com.company;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADD("+") {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    }, SUBTRACT("-") {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
    }, MULTIPLY("*") {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
    }, DIVISION("/") {
        @Override
        public double calculate(double a, double b) {
            return a / b;
        }
    };

    private final String sign;

    //private static final Operation[] VALUES = values();

    private static final Map<String, Operation> OPERATIONS;

    static {
        OPERATIONS = new HashMap<>();
        for (Operation value : values()) {
            OPERATIONS.put(value.sign, value);
        }
    }

    Operation(String sign) {
        this.sign = sign;
    }

    public abstract double calculate(double a, double b);

    public Operation findOperationBySign(String sign) {

        /*for (Operation operation : VALUES) {
            if(operation.sign.equals(sign)){
                return operation;
            }
        }*/
        Operation operation = OPERATIONS.get(sign);
        if (operation != null)
            return operation;
        throw new UnsupportedOperationException(sign);
    }
}
