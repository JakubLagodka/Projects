import interfaces.PaymentRule;
import interfaces.Reel;
import interfaces.Symbol;
import models.DigitSymbol;
import models.RandomReel;
import models.SpinResult;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameEngineTest {
    @Test
    public void shouldWinWhenAllSymbolsMatch(){
        //given
        List<Symbol> symbols = List.of(new DigitSymbol( 5) );
        List<Reel> reels = List.of(new RandomReel( symbols ), new RandomReel( symbols ) );

        PaymentRule paymentRule = new CustomPaymentRule( );

        GameEngine gameEngine = new GameEngine( reels,paymentRule );

        SpinResult spin = gameEngine.spin();

        assertTrue( spin.isWin() );
    }
}
