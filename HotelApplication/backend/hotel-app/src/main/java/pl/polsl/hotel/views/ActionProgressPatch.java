package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public class ActionProgressPatch {

    @ApiModelProperty(example = "OPN")
    @Nullable
    private String statusCode;

    @ApiModelProperty(example = "Done!", position = 1)
    @Nullable
    private String result;

    public ActionProgressPatch() {
    }

    @Nullable
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(@Nullable String statusCode) {
        this.statusCode = statusCode;
    }

    @Nullable
    public String getResult() {
        return result;
    }

    public void setResult(@Nullable String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ActionProgressPatch{" +
                "statusCode='" + statusCode + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
