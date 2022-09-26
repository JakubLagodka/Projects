package com.lagodka.santa;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class MyMessageReceiver {

    void onMessage(String message){
        List<Price> prices = new ArrayList<>();
    String[] splitMessage = message.split("\n");

        for (int i = 0; i < splitMessage.length; i++) {

        if (splitMessage[i].equals("…")) {
            continue;
        }
        String[] fields = splitMessage[i].split(",");
//        prices.add(new Price(Long.valueOf(fields[0]), fields[1],
//                BigDecimal.valueOf(Double.parseDouble(fields[2])),
//                BigDecimal.valueOf(Double.parseDouble(fields[3])),
//                fields[4]));
            Price price = new Price();
            price.setId(Long.valueOf(fields[0]));
            price.setCurrency(fields[1]);
            price.setBid(BigDecimal.valueOf(Double.parseDouble(fields[2])));
            price.setAsk(BigDecimal.valueOf(Double.parseDouble(fields[3])));
            price.setTimestamp(fields[4]);
            prices.add(price);
            System.out.println(prices.get(prices.size()-1));
    }
}
}
