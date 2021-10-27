package pl.lagodka.currency.service;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.lagodka.currency.model.CurrencyResponse;
import pl.lagodka.currency.service.exception.CurrencyNotFoundException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyServiceSimpleImplTest {

    final CurrencyService simpleCurrencyService = new CurrencyServiceSimpleImpl();

    private static Stream<Arguments> currencyValuesProvider() {
        return Stream.of(
                Arguments.of("EUR", 4.55),
                Arguments.of("PLN", 3, 55),
                Arguments.of("USD", 5, 55)
        );
    }

    @ParameterizedTest(name = "{index} => givenCurrencyCode={0}, expectedCurrencyValue={1}}")
    @MethodSource("currencyValuesProvider")
    void should_return_correct_currency_value_when_currency_code_given(
            String givenCurrencyCode,
            Double expectedCurrencyValue
    ) {
        CurrencyResponse response = simpleCurrencyService.getCurrencyValueByCurrencyCode(givenCurrencyCode);

        assertEquals(expectedCurrencyValue, response.getCurrencyValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"xaz", "CHF", "", "ADASDcc"})
    void should_throw_CurrencyNotFoundException_when_wrong_currency_code_given(String currencyCode) {
        assertThrows(CurrencyNotFoundException.class, () -> simpleCurrencyService.getCurrencyValueByCurrencyCode(currencyCode));
    }
}
