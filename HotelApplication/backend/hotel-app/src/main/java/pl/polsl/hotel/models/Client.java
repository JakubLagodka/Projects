package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Client extends User {

    @OneToMany(mappedBy = "client")
    @NonNull
    private List<Object> objects = new LinkedList<>();

    public Client() {
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
        return "Client{" +
                "objects=" + objects +
                '}';
    }
}
