package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Warehouse {

    // Define variables to store beer inventory (key: beer name, value: quantity)
    private Map<String, Integer> inventory;

    // Define interfaces for Czarnkow and Miłosław breweries
    private CzarnkowBrewery czarnkowBrewery;
    private MiłosławBrewery miloslawBrewery;

    // Warehouse constructor
    public Warehouse(CzarnkowBrewery czarnkowBrewery, MiłosławBrewery miloslawBrewery) {
        this.inventory = new HashMap<>();
        this.czarnkowBrewery = czarnkowBrewery;
        this.miloslawBrewery = miloslawBrewery;
    }

    // Method to sell beer (decrease inventory)
    public void sellBeer(String beerName, int quantity) throws NoSuchElementException {
        if (getInventory(beerName) < quantity) {
            throw new NoSuchElementException("Not enough " + beerName + " in stock.");
        }
        inventory.put(beerName, getInventory(beerName) - quantity);
    }

    // Method to check inventory for a specific beer
    private int getInventory(String beerName) {
        return inventory.getOrDefault(beerName, 0);
    }

    // Method to automatically place order based on stock level (below 100)
    public void checkAndOrderStock() {
        for (String beer : inventory.keySet()) {
            if (getInventory(beer) < 100) {
                if (beer.startsWith("noteckie jasne")) {
                    czarnkowBrewery.orderBeer(beer); // Order from Czarnkow
                } else if (beer.startsWith("komes")) {
                    miloslawBrewery.orderBeer(beer); // Order from Miłosław
                }
                // Add logic for future breweries
            }
        }
    }

    // Method to accept beer deliveries (implementation depends on brewery communication)
    public void acceptBeer(String beerName, int quantity) {
        inventory.put(beerName, getInventory(beerName) + quantity);
    }

    // Method to generate report on beer inventory
    public String generateReport() {
        StringBuilder report = new StringBuilder("Warehouse Beer Report:\n");
        for (String beer : inventory.keySet()) {
            report.append(beer + " (")
                    .append(identifyBrewery(beer))
                    .append("): ")
                    .append(getInventory(beer))
                    .append("\n");
        }
        return report.toString();
    }

    // Helper method to identify brewery based on beer name (can be improved)
    private String identifyBrewery(String beerName) {
        if (beerName.startsWith("noteckie")) {
            return "Czarnków Brewery";
        } else if (beerName.startsWith("komes")) {
            return "Miłosław Brewery";
        }
        return "Unknown"; // Handle unknown beers
    }
}