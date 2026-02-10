package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class BracketsChecker {

    public static boolean checkBracketsUsingList(String input){
        System.out.printf("Checking given string: '%s' using list.%n", input);
        long startTime = new Date().getTime();
        List<Character> list = new ArrayList<>();
        for ( Character ch: input.toCharArray() ){
            if ("([{".contains(ch.toString())){
                list.add(ch);
            } else if (")]}".contains(ch.toString())) {
                if (list.isEmpty()){
                    return false;
                }
                char lastChar = list.getLast().charValue();
                if ((lastChar == '(' && ch.charValue() != ')') || (lastChar == '[' && ch.charValue() != ']') || (lastChar == '{' && ch.charValue() != '}') ){
                    return false;
                }
                list.removeLast();
            }
        }
        Long time = new Date().getTime() - startTime;
        System.out.println("Time for list: "+ time);
        return list.isEmpty();
    }

    public static boolean checkBracketsUsingStack(String input){
        System.out.printf("Checking given string: '%s' using stack.%n", input);
        long startTime = new Date().getTime();
        Stack<Character> stack = new Stack<>();
        for (Character c:input.toCharArray()){
            if ("([{".contains(c.toString())){
                stack.push(c);
            } else if (")]}".contains(c.toString())) {
                if (stack.isEmpty()){
                    return false;
                }
                char lastChar = stack.pop();
                if ((lastChar == '(' && c!=')') || (lastChar == '[' && c!=']') || (lastChar == '{' && c!='}')){
                    return false;
                }
            }
        }
        Long time = new Date().getTime() - startTime;
        System.out.println("Time for stack: "+ time);
        return stack.isEmpty();
    }

}
