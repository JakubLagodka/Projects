package pl.lagodka.currency.service;

import pl.lagodka.currency.model.CurrencyResponse;

public interface CurrencyService {
    CurrencyResponse getCurrencyValueByCurrencyCode(String code);
}
