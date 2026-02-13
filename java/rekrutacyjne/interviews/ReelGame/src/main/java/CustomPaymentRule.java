import interfaces.PaymentRule;
import interfaces.Symbol;

import java.util.List;

public class CustomPaymentRule implements PaymentRule {


    @Override
    public boolean isWin( List<Symbol> result ) {
        return result.stream()
                .allMatch( symbol -> symbol.equals( result.get(0) ) );
    }
}
