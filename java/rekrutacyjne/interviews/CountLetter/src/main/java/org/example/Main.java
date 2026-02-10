package org.example;

import javafx.util.Pair;

//"Given a string s with the value 'atlas', the source string is formed by repeating the string s
// multiple times up to a length of 1 billion characters.
// Your task is to count the number of occurrences of the character 'a' in the source string."
//this task is actually more about writing a math function, which will give the resulting number.
//Yes, the output is expected to be a number.
//
//the Answer is next:
//the length of word atlas is 5 characters.
//in source string file we will need exactly 200 million times the word "atlas".
//in each word we have twice letter "a", so answer is 400 million.
//the word 'atlas' can be changed to something different, for example
//'algorithm' which has 9 characters.
//
//so in 1 billion we can have exactly 111.111.111 full words 'algorithm'
// and then we are left only with single character which is 'a'.
// so in total we have 111_111_112 repeations of 'a'.
public class Main {
    private static Pair countLetterForLimitedLengthWithOptimisation(String input, char letter, long lengthLimit) {
        var fullCount = 0;
        var partialCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (letter == c) {
                if(lengthLimit > i) {
                    partialCount++;
                }
                fullCount++;
            }
        }
        return new Pair(fullCount, partialCount);
    }
    public static void main(String[] args) {
    }
}