package com.lagodka.santa;


import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class MessageReceiver {

    void onMessage(String message) {
        StringReader stringReader = new StringReader(message);
        List<Price> beans = new CsvToBeanBuilder(stringReader)
                .withType(Price.class)
                .withFilter(new EmptyLineFilter())
                .build()
                .parse();

        Collections.reverse(beans);
        Set<String> set = new HashSet<>();
        List<Price> priceList = beans.stream()
                .filter(price -> set.add(price.getCurrency()))
                .map(this::calculatePriceAfterCommissions)
                .collect(Collectors.toList());

        priceList.forEach(System.out::println);

//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject("http://localhost:8081/prices", priceList, Price.class);
//
//        System.out.println(restTemplate);
    }

    BigDecimal calculateAsk(BigDecimal amount) {
        BigDecimal value = amount.multiply(BigDecimal.valueOf(0.01));
        return amount.add(value);
    }

    BigDecimal calculateBid(BigDecimal amount) {
        BigDecimal value = amount.multiply(BigDecimal.valueOf(0.01));
        return amount.subtract(value);
    }

    Price calculatePriceAfterCommissions(Price price) {
        price.setAsk(calculateAsk(price.getAsk()));
        price.setBid(calculateBid(price.getBid()));
        return price;
    }
}
