package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "action_statuses")
public class ActionStatus extends CodeEntity {

    @Id
    @NonNull
    private String code;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @ManyToMany
    @NonNull
    private Set<ActionStatus> childActionStatuses = new HashSet<>();

    @ManyToMany
    @NonNull
    private Set<ActionStatus> parentActionStatuses = new HashSet<>();

    public ActionStatus() {
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Set<ActionStatus> getChildActionStatuses() {
        return childActionStatuses;
    }

    public void setChildActionStatuses(@NonNull Set<ActionStatus> childActionStatuses) {
        this.childActionStatuses = childActionStatuses;
    }

    @NonNull
    public Set<ActionStatus> getParentActionStatuses() {
        return parentActionStatuses;
    }

    public void setParentActionStatuses(@NonNull Set<ActionStatus> parentActionStatuses) {
        this.parentActionStatuses = parentActionStatuses;
    }

    @Override
    public String toString() {
        return "ActionStatus{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", childActionStatuses=" + childActionStatuses +
                ", parentActionStatuses=" + parentActionStatuses +
                '}';
    }
}
