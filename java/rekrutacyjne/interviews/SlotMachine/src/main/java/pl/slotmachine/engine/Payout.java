package pl.slotmachine.engine;

import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;

public record Payout() {
    public static Payout of( Integer score, List<Symbol> symbols ) {
        return null;
    }

    public static Payout none( List<Symbol> symbols ) {
        return null;
    }
}
