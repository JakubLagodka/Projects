package pl.slotmachine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.slotmachine.engine.Payout;
import pl.slotmachine.engine.PayoutEngine;
import pl.slotmachine.engine.WheelEngine;
import pl.slotmachine.engine.model.symbol.Symbol;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotMachineService {
    private final WheelEngine  wheelEngine;
    private final PayoutEngine payoutEngine;

    public Payout trigger(){
        List<Symbol> symbols = wheelEngine.rotateWheels();
        return payoutEngine.calculatePayout(symbols);
    }

}
