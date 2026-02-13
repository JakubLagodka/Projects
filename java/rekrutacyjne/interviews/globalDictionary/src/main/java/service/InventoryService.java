package service;

import model.Inventory;
import model.InventoryDictionary;

import java.util.Map;

public class InventoryService {
    private InventoryDictionary inventoryDictionary;

    public void addInventory( String name, Map<String, String> parameters ) {
        inventoryDictionary.addToInventory(name,parameters);
    }

    public Map<String,Inventory> retrieveInventory( String bread ) {
        return null;
    }
}
