package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class CodeName extends CodeEntity{


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

    @Override
    public String toString() {
        return "CodeName{" +
                ", name='" + name + '\'' +
                '}';
    }

    public CodeName() {
    }
}

