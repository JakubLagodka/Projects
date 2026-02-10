package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Machine {

    private Set<Coin> acceptedCoins;

    private Set<Product> productsSet;

    public Machine(Set<Coin> acceptedCoins, Set<Product> productsSet) {
        this.acceptedCoins = acceptedCoins;
        this.productsSet = productsSet;
    }
//nie dziala bo nie wydaje dobrze, to zla droga nie trzeba pamietac wrzucanych monet wystarczy ich wartosc!
    private Map<List<Integer>, Boolean> calculateChangeUsingInsertedCoins(List<Coin> coinsInserted, Product selectedProduct) {
        Map<List<Integer>, Boolean> isEnoughCash = new HashMap<>();
        AtomicInteger insertedCoinsSum = new AtomicInteger();
        double productCentValue = selectedProduct.getDollarsValue() * 100;
        List<Integer> change = new ArrayList<>();
        List<Coin> remainCoinsSorted = coinsInserted.stream().sorted(Comparator.comparing(Coin::getValue).reversed())
                .toList();

        remainCoinsSorted.stream().map(Coin::getValue).forEach(insertedCoinsSum::addAndGet);
        if (insertedCoinsSum.doubleValue() < productCentValue) {
            isEnoughCash.put(coinsInserted.stream().map(Coin::getValue).toList(), false);
            return isEnoughCash;
        }
        for (Coin coin : remainCoinsSorted) {
            double currentCoinValue = coin.getValue();
            if (productCentValue >= currentCoinValue) {
                productCentValue -= currentCoinValue;
            } else {
                double remain = coin.getValue() - productCentValue;
                int i = 0;
                List<Coin> coinList = acceptedCoins.stream().sorted(Comparator.comparing(Coin::getValue).reversed()).toList();
                while (remain > 0) {
                    if (coinList.get(i).getValue() <= remain) {
                        change.add(coinList.get(i).getValue());
                        remain -= coinList.get(i).getValue();
                        i--;
                    }
                    i++;
                }
            }
        }
        isEnoughCash.put(change, true);
        return isEnoughCash;
    }

    private Map<List<Integer>, Boolean> calculateChange(List<Coin> coinsInserted, Product selectedProduct) {
        Map<List<Integer>, Boolean> isEnoughCash = new HashMap<>();
        AtomicInteger insertedCoinsSum = new AtomicInteger();
        double productCentValue = selectedProduct.getDollarsValue() * 100;
        List<Integer> change = new ArrayList<>();

        coinsInserted.stream().map(Coin::getValue).forEach(insertedCoinsSum::addAndGet);
        if (insertedCoinsSum.doubleValue() < productCentValue) {
            isEnoughCash.put(coinsInserted.stream().map(Coin::getValue).toList(), false);
            return isEnoughCash;
        }
        //teraz od sumy odejmujemy koszt produktu
        double changeValue = insertedCoinsSum.doubleValue() - productCentValue;
        List<Coin> sorted = acceptedCoins.stream().sorted(Comparator.comparing(Coin::getValue).reversed()).toList();
        for (int i = 0; i < sorted.size(); i++) {
            int currentCoinValue = sorted.get(i).getValue();
            if (changeValue >= currentCoinValue) {
                if (currentCoinValue <= changeValue) {
                    change.add(currentCoinValue);
                    changeValue -= currentCoinValue;
                    i--;
                }
                if (changeValue == 0) {
                   break;
                }
            }
        }
        isEnoughCash.put(change, true);
        return isEnoughCash;
    }

    private boolean checkIfCoinsAreAccepted(List<Coin> coinsInserted) {
        for (Coin coin : coinsInserted) {
            if (acceptedCoins.stream().noneMatch((coin1) -> coin1.getValue() == coin.getValue())) {
                return false;
            }
        }
        return true;
    }

    public Map<Product, List<Integer>> purchase(String productName, List<Coin> coinsInserted) {
        Product selected = findProduct(productName);
        if (selected == null || !checkIfCoinsAreAccepted(coinsInserted)) {
            return new HashMap<>();
        }
        Map<Product, List<Integer>> productListMap = new HashMap<>();
        productListMap.put(Boolean.TRUE.equals(calculateChange(coinsInserted, selected).values().stream().findFirst().orElse(null)) ?
                selected : null, calculateChange(coinsInserted, selected).keySet().stream().findFirst().orElse(null));
        return productListMap;
    }

    private Product findProduct(String productName) {
        return productsSet.stream().filter(product -> product.getName().equals(productName)).findFirst().orElse(null);
    }
}
