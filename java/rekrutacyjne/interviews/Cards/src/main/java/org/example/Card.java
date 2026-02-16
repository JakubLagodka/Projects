package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
class CardModel {
    private String figure;
    private Color color;
    private Symbol symbol;

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}

class CardSuit implements Comparable<Card> {

    private final String rank;
    private final String suit;

    private static final Map<String, Integer> rankHierarchy = new HashMap<>();
    private static final Map<String, Integer> suitHierarchy = new HashMap<>();

    static {
        rankHierarchy.put("2", 2);
        rankHierarchy.put("3", 3);
        rankHierarchy.put("4", 4);
        rankHierarchy.put("5", 5);
        rankHierarchy.put("6", 6);
        rankHierarchy.put("7", 7);
        rankHierarchy.put("8", 8);
        rankHierarchy.put("9", 9);
        rankHierarchy.put("10", 10);
        rankHierarchy.put("Jack", 11);
        rankHierarchy.put("Queen", 12);
        rankHierarchy.put("King", 13);
        rankHierarchy.put("Ace", 14);

        suitHierarchy.put("Hearts", 4);
        suitHierarchy.put("Diamonds", 3);
        suitHierarchy.put("Clubs", 2);
        suitHierarchy.put("Spades", 1);
    }

    public CardSuit(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + " of " + rank;
    }

    @Override
    public int compareTo(Card other) {
        int valueComparison = Integer.compare(rankHierarchy.get(this.rank), rankHierarchy.get(other.value));
        if (valueComparison != 0) {
            return valueComparison;
        } else {
            return Integer.compare(suitHierarchy.get(this.suit), suitHierarchy.get(other.suit));
        }
    }
}
public class Card implements Comparable<Card> {

    String value;
    String suit;
    int rankValue;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
        this.rankValue = getRankValue(value);

    }

    private static int getRankValue(String value) {

        return switch ( value ) {
            case "Ace" -> 14;
            case "King" -> 13;
            case "Queen" -> 12;
            case "Jack" -> 11;
            default -> Integer.parseInt( value );
        };
    }

    private static int getSuitValue(String suit) {

        return switch ( suit ) {
            case "Hearts," -> 1;
            case "Diamonds" -> 2;
            case "Clubs" -> 3;
            case "Spades" -> 4;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
        if ( Objects.equals( this.suit, o.suit ) ) {

            return Integer.compare(this.rankValue, o.rankValue);
        }
        return Integer.compare(getSuitValue(this.suit), getSuitValue(o.suit));
    }
}

