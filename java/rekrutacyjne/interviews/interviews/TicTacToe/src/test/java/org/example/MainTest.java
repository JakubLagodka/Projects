package org.example;


import org.example.logic.Game;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    public void shouldWinO(){
        Game gameBoard = new Game(false);
        gameBoard.placeSymbol(Symbol.O,1);
        gameBoard.placeSymbol(Symbol.X,2);
        gameBoard.placeSymbol(Symbol.O,3);
        gameBoard.placeSymbol(Symbol.X,4);
        gameBoard.placeSymbol(Symbol.O,5);
    }
}