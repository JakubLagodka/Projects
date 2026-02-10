package org.example;

public class Item {
    private String name;
    private int value;
    private int weight;

public Item(String _name, int _value, int _weight){
    value = _value;
    name = _name;
    weight = _weight;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Integer getRatio() {
        return value/weight;
    }
}
