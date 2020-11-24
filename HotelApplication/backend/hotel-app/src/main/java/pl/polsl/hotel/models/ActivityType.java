package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "activity_types")

public class ActivityType extends CodeName {


    @OneToMany(mappedBy = "activityType")
    @NonNull
    private List<Activity> activities = new LinkedList<>();

    public ActivityType() {
    }

    @NonNull
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                ", activities=" + activities +
                '}';
    }

}

