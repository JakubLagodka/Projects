package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

public class RequestPost extends ActionPost {

    @ApiModelProperty(required = true, position = 1)
    @NonNull
    private Long objectId;

    public RequestPost() {
    }

    @NonNull
    public Long getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "RequestPost{" +
                "objectId=" + objectId +
                '}';
    }

    public void setObjectId(@NonNull Long objectId) {
        this.objectId = objectId;
    }
}
