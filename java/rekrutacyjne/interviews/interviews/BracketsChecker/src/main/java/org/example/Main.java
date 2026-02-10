package org.example;
//Napisz funkcję w Javie, która sprawdza, czy nawiasy w podanym ciągu znaków są poprawnie sparowane.
//Funkcja powinna:
//Zwracać true dla poprawnych nawiasów, false dla niepoprawnych.
//Obsługiwać nawisy (), [], {}.
//Uwzględniać zagnieżdżanie.
//Zakładać brak innych znaków w stringu.
import java.util.*;

public class Main {
    private final static String input = "([)]";
    private final static Map<String, String> POSSIBLE_BRACKETS = new HashMap<>();

    static {
        POSSIBLE_BRACKETS.put("(", ")");
        POSSIBLE_BRACKETS.put("{", "}");
        POSSIBLE_BRACKETS.put("[", "]");
    }

    public static void main(String[] args) {
        System.out.println(validateBracketString(input));
    }

    public static boolean validateBracketString(String input) {
        List<String> openedBrackets = new ArrayList<>();

        String[] splittedCharacters = input.split("");

        for (String currentCharacter : splittedCharacters) {
            if (POSSIBLE_BRACKETS.containsKey(currentCharacter)) {
                openedBrackets.add(currentCharacter);
            } else if (!openedBrackets.isEmpty() && POSSIBLE_BRACKETS.containsValue(currentCharacter) && POSSIBLE_BRACKETS.get(openedBrackets.getLast()).equals(currentCharacter)) {
                openedBrackets.removeLast();
            } else {
                return false;
            }
        }

        return openedBrackets.isEmpty();
    }
}