import service.InventoryService;

void main() {
    InventoryService inventoryService = new InventoryService();

    inventoryService.addInventory("Bread",Map.of("name","garlic bread"));
    inventoryService.addInventory( "MilkShake",Map.of("name","milkShake") );

    var inventory = inventoryService.retrieveInventory("Bread");

    System.out.println(inventory.get("").getName());
    inventory.get("").getProperties().entrySet()
            .forEach(entry -> {
                System.out.println(entry.getKey());
            });
    inventoryService.retrieveInventory("bread" ).get( "" ).getName();
}