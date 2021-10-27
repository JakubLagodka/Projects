package pl.lagodka.currency.service;

import pl.lagodka.currency.model.CurrencyResponse;
import pl.lagodka.currency.service.exception.CurrencyNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class CurrencyServiceSimpleImpl implements CurrencyService{

    public static final Map<String, Double> currencies = new HashMap<>();

    public CurrencyServiceSimpleImpl(){
        currencies.put("EUR", 4.55);
        currencies.put("USD", 5.55);
        currencies.put("PLN", 3.55);
    }
    @Override
    public CurrencyResponse getCurrencyValueByCurrencyCode(String code) throws CurrencyNotFoundException {
        String currencyCode = findCurrencyCodeInCurrencies(code)
                .orElseThrow(() -> new CurrencyNotFoundException(code));
        Double currencyValue = currencies.get(currencyCode);
        return new CurrencyResponse(currencyValue);
    }

    private Optional<String> findCurrencyCodeInCurrencies(String code){
        return currencies.keySet()
                .stream()
                .filter(areCurrencyCodesEqual(code))
                .findFirst();
    }

    private Predicate<String> areCurrencyCodesEqual(String code){
        return currency -> currency.equals(code);
    }
}
