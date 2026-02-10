package pl.slotmachine.engine.model;

import lombok.RequiredArgsConstructor;
import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ScoreTable {
    private final Map<String,Integer> scoreTable;
    public Optional<Integer> findScore( List<Symbol> symbols ) {
        String key = symbols.stream()
                .map( Symbol::getLabel )
                .collect( Collectors.joining());
        return Optional.ofNullable(scoreTable.get(key));
    }
}
