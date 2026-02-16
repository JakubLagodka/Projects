package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void quickSort() {
        quickSort(0, cards.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Card pivot = cards.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (cards.get(j).compareTo(pivot) <= 0) {
                i++;
                Card temp = cards.get(i);
                cards.set(i, cards.get(j));
                cards.set(j, temp);
            }
        }
        Card temp = cards.get(i + 1);
        cards.set(i + 1, cards.get(high));
        cards.set(high, temp);
        return i + 1;
    }

    public void shuffleRandom() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card card = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, card);
        }
    }

    void shuffle() {
        Collections.shuffle(cards);
    }

    void sort() {
        Collections.sort(cards);
    }

    void print() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
