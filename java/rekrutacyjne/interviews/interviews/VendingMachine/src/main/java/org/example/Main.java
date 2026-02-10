package org.example;

import java.util.List;
import java.util.Set;

public class Main {
//    You need to design a Vending Machine which accepts coins of 1, 2, 5, 10, 25, 50, 100 cents.
//    The vending machine has products with prices Coke ($2.50), Pepsi ($3.50) and Soda ($1.25).
//    Assuming the vending machine has an infinite supply of coins, calculate the minimum number of coins required to provide the change.
//    Design a method that accepts list of coins inserted and a product that user would like to buy.
//    Return the selected product and remaining change if any. If the product can't be bought,
//    the Vending Machine should return the same coins as inserted.
//
//    Example 1:
//    Input: product=Soda, coins=[100, 100]
//    Output: [50, 25]
//
//    Example 2:
//    Input: product=Coke, coins=[100, 100, 10, 10, 25, 50]
//    Output: [25, 10, 10]
//mozna nie tak zachlannie jak zrobilem lecz rekurencyjnie!
    public static void main(String[] args) {


        Machine machine = new Machine(
                Set.of(new Coin(1),new Coin(2),new Coin(5),new Coin(10),new Coin(25),new Coin(50),new Coin(100)),
                Set.of(new Product("Soda",1.25),new Product("Coke",2.5),new Product("Pepsi",3.5))
        );
        System.out.println(machine.purchase("Soda",List.of(new Coin(100),new Coin(100))));
        System.out.println(machine.purchase("Soda",List.of(new Coin(100))));
        System.out.println(machine.purchase("Coke",List.of(new Coin(100),new Coin(100),new Coin(10), new Coin(10), new Coin(25), new Coin(50))));
        System.out.println(machine.purchase("Soda",List.of(new Coin(100),new Coin(100),new Coin(10), new Coin(10), new Coin(25), new Coin(50))));
    }
}
