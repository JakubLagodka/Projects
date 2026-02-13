package models;

import interfaces.Symbol;

import java.util.List;

public record SpinResult(List<Symbol> symbols, boolean isWin) {
}
