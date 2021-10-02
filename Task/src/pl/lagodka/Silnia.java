package pl.lagodka;

import java.util.Scanner;

public class Silnia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę = ");
        int n = scanner.nextInt();
        System.out.println(silnia(n));
    }

    static int silnia(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int wynik = n;
            wynik *= silnia(n-1);
            return wynik;
        }
    }
}
