package org.example;

//Create a class Item with the following fields:
//name (String) - name of the item,
//value (int) - value of the item,
//weight (int) - weight of the item.
//Implement a class Knapsack, which contains:
//A method solveProblem(Item[] items, int capacity) - this method should take an array of items and the capacity of the knapsack
// as arguments, and return an array of items to be placed in the knapsack to maximize their total value.
//Write a main program that:
//Creates an array of items,
//Creates an object of the Knapsack class,
//Calls the solveProblem() method on the knapsack object,
//Displays the result (items placed in the knapsack and their total value).
//Sample Data:
//
//Consider the following items:
//
//Item 1: Name - "Laptop", Value - 1500, Weight - 3
//Item 2: Name - "Camera", Value - 1000, Weight - 1
//Item 3: Name - "Guitar", Value - 500, Weight - 4
//Item 4: Name - "Phone", Value - 700, Weight - 2
//Item 5: Name - "Watch", Value - 300, Weight - 1
//Item 6: Name - "Headphones", Value - 200, Weight - 1
//Item 7: Name - "Tablet", Value - 600, Weight - 2
//Item 8: Name - "Books", Value - 400, Weight - 2
//And a knapsack with a capacity of 6 units.
//
//        Solution:
//
//For the given data, the optimal solution would be to place the "Laptop", "Camera", and "Phone" in the knapsack,
// maximizing the total value to 3200 (1500 + 1000 + 700) with a total weight of 6 (3 + 1 + 2).
public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[8];
        items[0] = new Item("Laptop",1500,6);
        items[1] = new Item("Camera",1000,2);
        items[2] = new Item("Guitar",500,4);
        items[3] = new Item("Phone",700,2);
        items[4] = new Item("Watch",300,1);
        items[5] = new Item("Headphones",200,1);
        items[6] = new Item("Tablet",600,2);
        items[7] = new Item("Books",400,2);
        Knapsack knapsack = new Knapsack();
//        Item[] solvedProblem = knapsack.solveProblem(items, 6);
    }
}