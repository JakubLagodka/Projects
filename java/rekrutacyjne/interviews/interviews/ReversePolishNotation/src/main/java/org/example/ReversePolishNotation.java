package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    private final List<String> operators;

    public ReversePolishNotation() {
        this.operators = new ArrayList<>();
        this.operators.add("+");
        this.operators.add("-");
        this.operators.add("*");
        this.operators.add("/");
    }

    public double calculate(String expression) {
        if (expression.isEmpty()) {
            return 0.0;
        }
        String[] split = expression.split(" ");
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (operators.contains(split[i])) {
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();

                if (split[i].equals("+")) {
                    stack.add(firstNumber + secondNumber);
                }
                if (split[i].equals("-")) {
                    stack.add(firstNumber - secondNumber);
                }
                if (split[i].equals("*")) {
                    stack.add(firstNumber * secondNumber);
                }
                if (split[i].equals("/")) {
                    stack.add(firstNumber / secondNumber);
                }
            } else  {
                stack.add(Double.parseDouble(split[i]));
            }
        }
        return stack.pop();
    }
    public int evalRPN(String[] tokens) {
        List<String> operators;
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        if (tokens.length < 2) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();

                if (tokens[i].equals("+")) {
                    stack.add(firstNumber + secondNumber);
                }
                if (tokens[i].equals("-")) {
                    stack.add(firstNumber - secondNumber);
                }
                if (tokens[i].equals("*")) {
                    stack.add(firstNumber * secondNumber);
                }
                if (tokens[i].equals("/")) {
                    stack.add(firstNumber / secondNumber);
                }
            } else  {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
