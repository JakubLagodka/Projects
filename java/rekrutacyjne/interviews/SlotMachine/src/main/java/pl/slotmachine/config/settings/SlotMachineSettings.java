package pl.slotmachine.config.settings;

import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;
import java.util.Map;

public interface SlotMachineSettings {

    int getNumberOfWheels();
    List<? extends Symbol> getWheelSymbols();
    Map<String,Integer> getScoreTable();
}
