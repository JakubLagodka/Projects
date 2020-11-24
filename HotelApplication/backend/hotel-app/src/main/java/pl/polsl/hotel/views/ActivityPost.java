package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


public class ActivityPost extends ActionPost {

    @ApiModelProperty(required = true, position = 1)
    @NonNull
    private Long requestId;

    @ApiModelProperty(example = "REF", position = 2)
    @Nullable
    private String activityTypeCode;

    @ApiModelProperty(position = 3)
    @Nullable
    private Long workerId;

    public ActivityPost() {
    }

    @NonNull
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(@NonNull Long requestId) {
        this.requestId = requestId;
    }

    @Nullable
    public String getActivityTypeCode() {
        return activityTypeCode;
    }

    public void setActivityTypeCode(@Nullable String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
    }

    @Nullable
    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(@Nullable Long workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "ActivityPost{" +
                "requestId=" + requestId +
                ", activityTypeCode='" + activityTypeCode + '\'' +
                ", workerId=" + workerId +
                '}';
    }
}
