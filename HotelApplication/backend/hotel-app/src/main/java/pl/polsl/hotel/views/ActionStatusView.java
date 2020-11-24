package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.util.List;

public class ActionStatusView {

    @ApiModelProperty(required = true, example = "OPN")
    @NonNull
    private String code;

    @ApiModelProperty(required = true, example = "Open", position = 1)
    @NonNull
    private String name;

    @ApiModelProperty(required = true, position = 2)
    @NonNull
    private List<String> childrenCodes;

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
    public List<String> getChildrenCodes() {
        return childrenCodes;
    }

    public void setChildrenCodes(@NonNull List<String> childrenCodes) {
        this.childrenCodes = childrenCodes;
    }

    public ActionStatusView() {
    }

    @Override
    public String toString() {
        return "ActionStatusView{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", childrenCodes=" + childrenCodes +
                '}';
    }
}
