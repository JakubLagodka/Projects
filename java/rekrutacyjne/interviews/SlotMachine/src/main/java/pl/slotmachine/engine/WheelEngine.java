package pl.slotmachine.engine;

import lombok.RequiredArgsConstructor;
import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;
@RequiredArgsConstructor
public class WheelEngine {

    public interface SymbolSelector {
        Symbol selectSymbol( Wheel wheel );
    }
    private final List<Wheel> wheels;
    private final SymbolSelector symbolSelector;

    public List<Symbol> rotateWheels() {
        return wheels.stream()
                .map( this::drawSymbol )
                .toList();
    }
    public Symbol drawSymbol( Wheel wheel ) {
        return symbolSelector.selectSymbol( wheel );
    }
}
