package pl.lagodka.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lagodka.currency.model.CurrencyResponse;
import pl.lagodka.currency.service.CurrencyService;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("/{code}")
    @ResponseBody
    public CurrencyResponse getCurrencyValue(@PathVariable String code){
        return currencyService.getCurrencyValueByCurrencyCode(code);
    }
}
