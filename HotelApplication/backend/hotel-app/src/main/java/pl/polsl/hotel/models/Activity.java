package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activities")

public class Activity extends Action {

    @ManyToOne
    @Nullable
    private Worker worker;

    @ManyToOne(optional = false)
    @Nullable
    private ActivityType activityType;

    @ManyToOne(optional = false)
    @NonNull
    private Request request;

    public Activity() {
    }

    @Nullable
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(@Nullable Worker worker) {
        this.worker = worker;
    }

    @Nullable
    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(@Nullable ActivityType activityType) {
        this.activityType = activityType;
    }

    @NonNull
    public Request getRequest() {
        return request;
    }

    public void setRequest(@NonNull Request request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "worker=" + worker +
                ", activityType=" + activityType +
                ", request=" + request +
                '}';
    }

}
