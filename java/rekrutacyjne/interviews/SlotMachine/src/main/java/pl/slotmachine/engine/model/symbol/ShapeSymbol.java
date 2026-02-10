package pl.slotmachine.engine.model.symbol;

import java.util.Objects;

public record ShapeSymbol(String name, String color) implements Symbol {
    public ShapeSymbol{
        Objects.requireNonNull(name);
        Objects.requireNonNull(color);
    }
    @Override
    public String getLabel() {
        return "" + name.charAt(0) +  color.charAt(0);
    }
}
