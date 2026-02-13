import interfaces.PaymentRule;
import interfaces.Reel;
import interfaces.Symbol;
import models.SpinResult;

import java.util.List;

public class GameEngine {
    private final List<Reel> reels;
    private final PaymentRule customPaymentRule;

    public GameEngine(List<Reel> reels, PaymentRule customPaymentRule) {
        this.reels = reels;
        this.customPaymentRule = customPaymentRule;
    }

    public SpinResult spin() {
        List<Symbol> symbols = reels.stream()
                .map( Reel::spin )
                .toList();

        boolean isWin = customPaymentRule.isWin( symbols );

        return new SpinResult(symbols,isWin);
    }
}
