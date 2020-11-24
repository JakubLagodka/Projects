package pl.polsl.hotel.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass

public abstract class Action{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    @Column(name = "description")
    @Nullable
    private String description;

    @ManyToOne
    @NonNull
    private ActionStatus actionStatus;

    @Column(name = "result")
    @Nullable
    private String result;

    @Column(name = "register_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NonNull
    private Date registerDate = new Date();

    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Nullable
    private Date endDate = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @NonNull
    public ActionStatus getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(@NonNull ActionStatus actionStatus) {
        this.actionStatus = actionStatus;
    }

    @Nullable
    public String getResult() {
        return result;
    }

    public void setResult(@Nullable String result) {
        this.result = result;
    }

    @NonNull
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@NonNull Date registerDate) {
        this.registerDate = registerDate;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionId=" + id +
                ", description='" + description + '\'' +
                ", actionStatus=" + actionStatus +
                ", result='" + result + '\'' +
                ", registerDate=" + registerDate +
                ", endDate=" + endDate +
                '}';
    }

    public Action() {
    }
}
