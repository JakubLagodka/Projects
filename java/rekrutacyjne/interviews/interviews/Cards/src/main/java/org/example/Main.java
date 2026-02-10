package org.example;

import java.util.List;

//Task: Implement a deck of cards in Java, enabling shuffling, sorting, and comparing cards.
//Method shuffle() for shuffling cards in the deck.
//        Method sort() for sorting cards in the deck.
//        Method for comparing cards based on their values - similarly to the game of War
//        (bonus points for handling ties like in the game of War).
public class Main {
    public static void main(String[] args) {
//        List<Card> cards1 = allCards.subList(0, ((allCards.size()) / 2));
//        List<Card> cards1 = cards.stream()
//                .limit(0)
//                .skip(cards.size() / 2)
//                .toList();
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