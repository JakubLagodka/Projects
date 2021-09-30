package pl.lagodka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotek {
    public static void main(String[] args) {
        List<Integer> userNumbers = new ArrayList<>();
        List<Integer> generatedNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź 6 liczb do losowania");
        for (int i = 0; i < 6; i++) {
            System.out.println("Wprowadź liczbę nr " + (i+1) + " = ");
            int myInt = scanner.nextInt();
            userNumbers.add(myInt);
           // System.out.println(myInt);
        }
        System.out.println("Wprowadzone liczby to: " + userNumbers);
        for (int i = 0; i < 6; i++) {

            int myInt = (int)(Math.random()* 99);
            generatedNumbers.add(myInt);
        }
        System.out.println("Wylosowane liczby to: " + generatedNumbers);
    }
}
