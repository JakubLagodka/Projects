package org.example;
//Reverse Polish Notation is a way of noting mathematical expressions without need of using parenthesis to keep operations order.
//
//For example:
//
//        ((2 + 7) / 3 + (14 − 3) * 4) / 2
//
//Can be written in RPN as:
//
//        2 7 + 3 / 14 3 − 4 * + 2 /
//
//An operation is applied to preceding operands, and then the result is treated as a single operand.
//
//Write a function that accepts a single String with RPN expression and returns a result as a number.
//
//Example:
//
//Input: "6 3 5 + 8 * +"
//
//Output: 70
public class Main {
    public static void main(String[] args) {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        System.out.println(reversePolishNotation.calculate("6 3 5 + 8 * +"));
        System.out.println(reversePolishNotation.evalRPN(new String[]{"6", "3", "5", "+", "8", "*", "+"}));
        System.out.println(reversePolishNotation.evalRPN(new String[]{"4","13","5","/","+"}));
    }
}