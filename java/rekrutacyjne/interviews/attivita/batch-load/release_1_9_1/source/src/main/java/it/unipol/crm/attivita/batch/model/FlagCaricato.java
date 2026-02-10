package it.unipol.crm.attivita.batch.model;

public enum FlagCaricato {
    TO_MIGRATE(0),
    SUCCESSFUL(2),
    ERROR(3),
    SKIPPED(4),
    WRONG_UPDATE_DATE(5);

    private final Integer code;

    FlagCaricato(Integer key) {
        this.code = key;
    }


    public Integer getCode() {
        return code;
    }
}
