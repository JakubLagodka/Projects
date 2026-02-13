package models;

import interfaces.Symbol;

public record DigitSymbol(int value) implements Symbol {
    @Override
    public String getValue() {
        return String.valueOf( value );
    }
}
