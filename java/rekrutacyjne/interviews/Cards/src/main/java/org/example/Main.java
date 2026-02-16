package org.example;

import java.util.List;

//Task: Implement a deck of cards in Java, enabling shuffling, sorting, and comparing cards.
//Method shuffle() for shuffling cards in the deck.
//        Method sort() for sorting cards in the deck.
//        Method for comparing cards based on their values - similarly to the game of War
//        (bonus points for handling ties like in the game of War).
//Homework: Implement Card Deck Logic (Shuffle, Sort, Compare)
//        Requirements:
//        Shuffle Functionality: Enable a shuffle() method to provide a random distribution of cards.
//        Sort Functionality: Implement a sort() method to return the deck to a structured order.
//        Comparison: Implement the Comparable or Comparator interface to evaluate card strength.

        public class Main {
    public static void main(String[] args) {

            List<Card> cards = List.of(new Card( "10","Spades" ), new Card("2","Hearts"));
            System.out.println(cards);
            Deck deck = new Deck();
            System.out.println("Original Deck: ");
            deck.print();
            deck.shuffle();
            System.out.println("\nShuffled Deck:");
            deck.print();
            deck.sort();
            System.out.println("\nSorted Deck");
            deck.print();

            Card card1 = new Card("Ace", "Spades");
            Card card2 = new Card("Ace", "Hearts");
            System.out.println("\nComparing cards: ");
            System.out.println(card1 + " vs " + card2);
            System.out.println(card1.compareTo(card2) > 0 ? card1 + " wins" : card2 + " wins");

            Deck deck1 = new Deck();
            deck1.shuffleRandom();
            deck1.print();
    }
}