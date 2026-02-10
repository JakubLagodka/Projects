package pl.slotmachine.engine;

import lombok.RequiredArgsConstructor;
import pl.slotmachine.engine.model.ScoreTable;
import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;

@RequiredArgsConstructor
public class PayoutEngine {
    private final ScoreTable  scoreTable;

    public Payout calculatePayout( List<Symbol> symbols ) {
        return scoreTable.findScore(symbols)
                .map( score-> Payout.of(score,symbols) )
                .orElse( Payout.none(symbols) );
    }
}
