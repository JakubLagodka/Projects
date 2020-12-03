package pl.polsl.hotel.models;


import org.springframework.lang.NonNull;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class CodeEntity {

    @Id
    @NonNull
    private String code;

    public CodeEntity() {
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                "code='" + code + '\'' +
                '}';
    }
}
