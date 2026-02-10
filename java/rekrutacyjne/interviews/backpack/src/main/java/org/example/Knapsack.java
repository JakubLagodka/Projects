package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {
    Item[] solveProblemUnfinished(Item[] items, int capacity){
        List<Item> mostValuableItems = new ArrayList<>();
        List<Item> sortedItems = Arrays.stream(items).sorted(Comparator.comparingInt(Item::getValue).reversed()).toList();
        int space = capacity;
        for (Item sortedItem : sortedItems) {
            if (sortedItem.getWeight() <= space){
                space -= sortedItem.getWeight();
                mostValuableItems.add(sortedItem);
             }
        }
        return mostValuableItems.toArray(Item[]::new);
    }
    public Item[] solveProblemRatio(Item[] items, int capacity) {
        List<Item> input = new ArrayList<>(Arrays.asList(items));

        input.sort((o1, o2) -> {
            int i = o2.getRatio().compareTo(o1.getRatio());  //ratio is value/weight ratio
            if (i == 0) {
                i = o2.getWeight().compareTo(o1.getWeight());
            }
            return i;
        });
        List<Item> result = new ArrayList<>();
        int spareCap;
        int smallestSpareItemCap;
        do {
            spareCap = capacity - result.stream().mapToInt(Item::getWeight).sum();
            smallestSpareItemCap = input.stream().mapToInt(Item::getWeight).min().getAsInt();
            extractItems(spareCap, input, result);
        } while (spareCap > smallestSpareItemCap);
        return result.toArray(new Item[0]);
    }

    private static void extractItems(int capacity, List<Item> input, List<Item> result) {
        for (Item item : input) {
            if (item.getWeight() <= capacity) {
                capacity -= item.getWeight();
                result.add(item);
            }
        }
        input.removeAll(result);
    }
    public static List<Item> solveProblem(Item[] items, int capacity) {
        List<Item> chooseItem = new ArrayList<>();
        List<Item> itemsGroup =  Arrays.asList(items);
        chooseItemRec(itemsGroup, capacity, chooseItem, itemsGroup.size());
        return chooseItem;
    }

    private static double chooseItemRec(List<Item> items, int capacity, List<Item> chooseItem, int element) {
        if ( element == 0 || capacity ==0) {
            return 0;
        }

        Item majorItem = items.get(element -1);

        if (majorItem.getWeight() > capacity) {
            return chooseItemRec(items, capacity, chooseItem, element -1);
        }

        // majotItem + value(next) if capacity - majorItem.weight > value(next) if capacity(max)
        int internalCapacity = capacity;

        List<Item> include = new ArrayList<>(chooseItem);
        include.add(majorItem);

        double itemReduce = chooseItemRec(items, internalCapacity - majorItem.getWeight(),  include, element -1);
        double itemWithNoReduceCapacity = chooseItemRec(items, capacity, chooseItem, element -1);

        if (majorItem.getValue() + itemReduce > itemWithNoReduceCapacity) {
            chooseItem.clear();
            chooseItem.addAll(include);
            return majorItem.getValue() + itemReduce;
        }

        return itemWithNoReduceCapacity;

    }
}
