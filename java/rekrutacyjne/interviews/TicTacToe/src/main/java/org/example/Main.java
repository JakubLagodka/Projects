package org.example;

import org.example.gui.MyFrame;

import java.awt.*;

//Develop a Java application for playing Tic-Tac-Toe on a 3x3 board. The game should support two players taking turns,
// detect the winner or declare a tie, and allow multiple rounds of play.
//
//        Requirements:
//
//        •	Implement a 3x3 game board where two players can place their symbols (X and O) alternately.
//        •	The game should detect and announce the winner when a player aligns three of their symbols horizontally, vertically,
//        or diagonally, or declare a tie if the board is full with no winner.
//	•	Provide a user interface (console or GUI) that displays the board, prompts players for their moves, and shows game results.
//	•	Include unit tests for the game logic to validate moves, detect wins, and handle ties.
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}