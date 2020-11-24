package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;


public class RequestView extends ActionView {

    @ApiModelProperty(required = true, position = 6)
    @NonNull
    private Long objectId;

    public RequestView() {
    }

    @NonNull
    public Long getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "RequestView{" +
                "objectId=" + objectId +
                '}';
    }

    public void setObjectId(@NonNull Long objectId) {
        this.objectId = objectId;
    }
}
