package org.example;

public class WarGame {
    public static void main(String[] args) {

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
    }
}