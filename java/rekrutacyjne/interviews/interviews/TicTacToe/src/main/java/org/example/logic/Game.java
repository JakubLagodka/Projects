package org.example.logic;

import org.example.Coordinate;
import org.example.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Map<Coordinate, Symbol> placeSymbol;

    private boolean XTurn;

    private boolean gameOver;

    private boolean tie;

    public Game(boolean XTurn) {
        this.placeSymbol = new HashMap<>();
        this.XTurn = XTurn;
        this.gameOver = false;
        this.tie = false;
    }

    public boolean isXTurn() {
        return XTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isTie() {
        return tie;
    }

    public List<Coordinate> placeSymbol(Symbol symbol, int coordinate) {
        if (placeSymbol.containsKey(coordinate)) {
            return null;
        }
        if (symbol == Symbol.X && XTurn) {
            placeSymbol.put(Coordinate.values()[coordinate], symbol);
        } else if (symbol == Symbol.O && !XTurn) {
            placeSymbol.put(Coordinate.values()[coordinate], symbol);
        } else   return null;

        XTurn = !XTurn;
        placeSymbol.put(Coordinate.values()[coordinate], symbol);
        if (checkIfWin(symbol) != null) {
            gameOver = true;
            return checkIfWin(symbol);
        } else if (placeSymbol.keySet().size() == 9) {
            gameOver = true;
            tie = true;
        }
        return null;
    }

    private List<Coordinate> checkIfWin(Symbol symbol) {
        List<Coordinate> CoordinateList = placeSymbol.entrySet().stream().filter(CoordinateSymbolEntry ->
                CoordinateSymbolEntry.getValue().equals(symbol)).map(Map.Entry::getKey).toList();

        return checkHorizontal(CoordinateList) != null ? checkHorizontal(CoordinateList) :
                checkVertical(CoordinateList) != null ?  checkVertical(CoordinateList) :
                        checkCross(CoordinateList)  != null ? checkCross(CoordinateList) :
                                null;
    }

    private List<Coordinate> checkHorizontal(List<Coordinate> CoordinateList) {

        if (CoordinateList.contains(Coordinate.UP_LEFT) && CoordinateList.contains(Coordinate.UP) &&
                CoordinateList.contains(Coordinate.UP_RIGHT)) {
            return List.of(Coordinate.UP_LEFT,Coordinate.UP,Coordinate.UP_RIGHT);
        } else if (CoordinateList.contains(Coordinate.LEFT) && CoordinateList.contains(Coordinate.RIGHT) &&
                CoordinateList.contains(Coordinate.CENTER)) {
            return List.of(Coordinate.LEFT,Coordinate.RIGHT,Coordinate.CENTER);
        } else if (CoordinateList.contains(Coordinate.DOWN_RIGHT) && CoordinateList.contains(Coordinate.DOWN_LEFT) &&
                CoordinateList.contains(Coordinate.DOWN)) {
            return List.of(Coordinate.DOWN_RIGHT,Coordinate.DOWN_LEFT,Coordinate.DOWN);
        }
        return null;
    }

    private List<Coordinate> checkVertical(List<Coordinate> CoordinateList) {

        if (CoordinateList.contains(Coordinate.UP_LEFT) && CoordinateList.contains(Coordinate.LEFT) &&
                CoordinateList.contains(Coordinate.DOWN_LEFT)) {
               return List.of(Coordinate.UP_LEFT,Coordinate.LEFT,Coordinate.DOWN_LEFT);
        } else if (CoordinateList.contains(Coordinate.UP_RIGHT) && CoordinateList.contains(Coordinate.RIGHT) &&
                CoordinateList.contains(Coordinate.DOWN_RIGHT)) {
               return List.of(Coordinate.UP_RIGHT,Coordinate.RIGHT,Coordinate.DOWN_RIGHT);
        } else if (CoordinateList.contains(Coordinate.UP) && CoordinateList.contains(Coordinate.CENTER) &&
                CoordinateList.contains(Coordinate.DOWN)) {
               return List.of(Coordinate.CENTER,Coordinate.UP,Coordinate.DOWN);
        }
        return null;
    }

    private List<Coordinate> checkCross(List<Coordinate> CoordinateList) {

        if (CoordinateList.contains(Coordinate.UP_LEFT) && CoordinateList.contains(Coordinate.CENTER) &&
                CoordinateList.contains(Coordinate.DOWN_RIGHT)) {
              return List.of(Coordinate.UP_LEFT,Coordinate.DOWN_RIGHT,Coordinate.CENTER);
        } else if (CoordinateList.contains(Coordinate.UP_RIGHT) && CoordinateList.contains(Coordinate.CENTER) &&
                CoordinateList.contains(Coordinate.DOWN_LEFT)) {
              return List.of(Coordinate.UP_RIGHT,Coordinate.DOWN_LEFT,Coordinate.CENTER);
        }
        return null;
    }

}
