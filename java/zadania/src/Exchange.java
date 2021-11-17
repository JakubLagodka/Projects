import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Currency;

public class Exchange {
//    Money exchange(Money amount, Currency convertTo) throws RateUnavailableException {
//        //throw new UnsupportedOperationException("Please, implement me");
//        BigDecimal convertedAmount = amount.getAmount();
//
//        convertedAmount = convertedAmount.multiply(forexEngine.getExchangeRate(new Pair(amount.getCurrency(),convertTo)));
//
//        Money converted = new Money(convertedAmount,convertTo);
//
//        return converted;
//    }
//    BigDecimal update(Pair pair, BigDecimal exchangeRate, ZonedDateTime quoteTime) throws QuoteOutdatedException {
//        //throw new UnsupportedOperationException("Please, implement me");
//        Bid bid = rates.get(pair);
//
//        if(bid == null || bid.getExchangeRate() == null)
//            return BigDecimal.valueOf(0);
//
//        if (quoteTime.isBefore(bid.getQuoteTime()))
//            throw new QuoteOutdatedException();
//
//        BigDecimal exchangeRateChange = exchangeRate.subtract(bid.getExchangeRate());
//
//        rates.put(pair, new Bid(exchangeRate, quoteTime));
//
//        return exchangeRateChange;
//    }
}
