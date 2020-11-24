package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Table(name = "object_types")
@Entity

public class ObjectType extends CodeName {


    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @OneToMany(mappedBy = "objectType")
    @NonNull
    private List<Object> objects = new LinkedList<>();


    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(@NonNull List<Object> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ObjectType{" +
                ", name='" + name + '\'' +
                ", objects=" + objects +
                '}';
    }

    public ObjectType() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, objects);
    }
}
