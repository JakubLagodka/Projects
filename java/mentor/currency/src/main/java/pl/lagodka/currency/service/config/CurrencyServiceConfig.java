package pl.lagodka.currency.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lagodka.currency.service.CurrencyService;
import pl.lagodka.currency.service.CurrencyServiceSimpleImpl;

@Configuration
public class CurrencyServiceConfig {

    @Bean
    protected CurrencyService simpleCurrencyService(){
        return new CurrencyServiceSimpleImpl();
    }

}
