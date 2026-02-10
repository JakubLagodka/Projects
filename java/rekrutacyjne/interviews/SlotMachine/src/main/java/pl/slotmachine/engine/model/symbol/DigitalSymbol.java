package pl.slotmachine.engine.model.symbol;

import java.util.Objects;

public record DigitalSymbol(Integer value) implements Symbol {
    public DigitalSymbol {
        Objects.requireNonNull(value);
    }

    @Override
    public String getLabel() {
        return value.toString();
    }
}
