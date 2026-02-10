package it.unipol.crm.attivita.batch.model;

public enum Action {

    INSERT("I"),
    UPDATE("U");

    private final String key;

    Action(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
