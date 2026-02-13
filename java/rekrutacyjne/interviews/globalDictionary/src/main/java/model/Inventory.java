package model;

import java.util.Map;

public class Inventory {

    private String name;
    private Map<String, String> properties;

    public static Inventory addNew(String name, Map<String, String> properties) {
        return new Inventory(name, properties);
    }

    public Inventory(String name, Map<String, String> properties) {
        this.name = name;
        this.properties = properties;
    }
    public String getName() {
        return name;
    }
    public Map<String, String> getProperties() {
        return properties;
    }
}
