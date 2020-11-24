package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Manager extends User {

    @OneToMany(mappedBy = "manager")
    @NonNull
    private List<Request> requests = new LinkedList<>();

    public Manager() {
    }

    @NonNull
    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(@NonNull List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "requests=" + requests +
                '}';
    }
}
