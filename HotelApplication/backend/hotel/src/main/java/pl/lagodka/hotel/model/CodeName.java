package pl.lagodka.hotel.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class CodeName {

    @Id
    @NonNull
    private String code;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;


    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
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
        return "CodeName{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public CodeName() {
    }
}

