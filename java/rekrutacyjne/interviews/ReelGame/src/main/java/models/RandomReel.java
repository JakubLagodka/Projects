package models;

import interfaces.Reel;
import interfaces.Symbol;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class RandomReel implements Reel {
    private List<Symbol> symbols;
    private Function<List<Symbol>, Symbol> generator;

    public RandomReel(List<Symbol> symbols) {
        this.symbols = symbols;
    }


    @Override
    public Symbol spin() {
        Random random = new Random();
        return symbols.get(random.nextInt(symbols.size()));
    }
}
