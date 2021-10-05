package pl.lagodka;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadż liczbę żeby wyliczyć ją z Fibonacciego = ");
        int number = scanner.nextInt();
        System.out.println(fibonacci(number));
    }

    static int fibonacci(int number) {
        if (number < 2) {
            return 1;
        } else if (number == 2) {
            return 2;
        }
        else{
            int result =  fibonacci(number-1) + fibonacci(number-2);
            return result;
        }
    }
}
