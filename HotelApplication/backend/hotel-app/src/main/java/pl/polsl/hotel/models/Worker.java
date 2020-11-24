package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Worker extends User {

    @OneToMany(mappedBy = "worker")
    @NonNull
    private List<Activity> activities = new LinkedList<>();

    @NonNull
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "activities=" + activities +
                '}';
    }

    public Worker() {
    }
}
