package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;

public class ActivityPatch extends ActionPatch {

    @ApiModelProperty(example = "REF", position = 1)
    @Nullable
    private String activityTypeCode;

    @ApiModelProperty(hidden = true)
    private Boolean hasActivityTypeCode = false;

    @ApiModelProperty(position = 2)
    @Nullable
    private Long workerId;

    @ApiModelProperty(hidden = true)
    private Boolean hasWorkerId = false;

    public void setActivityTypeCode(@Nullable String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
        this.hasActivityTypeCode = true;
    }

    public void setWorkerId(@Nullable Long workerId) {
        this.workerId = workerId;
        this.hasWorkerId = true;
    }

    public ActivityPatch() {
    }

    @Nullable
    public String getActivityTypeCode() {
        return activityTypeCode;
    }

    public Boolean getHasActivityTypeCode() {
        return hasActivityTypeCode;
    }

    @Nullable
    public Long getWorkerId() {
        return workerId;
    }

    public Boolean getHasWorkerId() {
        return hasWorkerId;
    }

    @Override
    public String toString() {
        return "ActivityPatch{" +
                "activityTypeCode='" + activityTypeCode + '\'' +
                ", hasActivityTypeCode=" + hasActivityTypeCode +
                ", workerId=" + workerId +
                ", hasWorkerId=" + hasWorkerId +
                '}';
    }
}
