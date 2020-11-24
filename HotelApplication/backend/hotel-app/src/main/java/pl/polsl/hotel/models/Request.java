package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "requests")

public class Request extends Action {

    @ManyToOne
    @Nullable
    private Manager manager;

    @OneToMany(mappedBy = "request", cascade = CascadeType.REMOVE)
    @NonNull
    private List<Activity> activities = new LinkedList<>();

    @ManyToOne(optional = false)
    @NonNull
    private Object object;

    @Nullable
    public Manager getManager() {
        return manager;
    }

    public void setManager(@Nullable Manager manager) {
        this.manager = manager;
    }

    @NonNull
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    @NonNull
    public Object getObject() {
        return object;
    }

    public void setObject(@NonNull Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Request{" +
                "manager=" + manager +
                ", activities=" + activities +
                ", object=" + object +
                '}';
    }

    public Request() {
    }
}
