package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Table(name = "objects")
@Entity
public class Object{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @ManyToOne(optional = false)
    @NonNull
    private ObjectType objectType;

    @ManyToOne(optional = false)
    @NonNull
    private Client client;

    @OneToMany(mappedBy = "object")
    @NonNull
    private List<Request> requests = new LinkedList<>();

    public Object() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(@NonNull ObjectType objectType) {
        this.objectType = objectType;
    }

    @NonNull
    public Client getClient() {
        return client;
    }

    public void setClient(@NonNull Client client) {
        this.client = client;
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
        return "Object{" +
                "objectId=" + id +
                ", name='" + name + '\'' +
                ", objectType=" + objectType +
                ", client=" + client +
                ", requests=" + requests +
                '}';
    }
}
