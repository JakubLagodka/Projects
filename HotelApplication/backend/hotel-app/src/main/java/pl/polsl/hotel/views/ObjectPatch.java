package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public class ObjectPatch {

    @ApiModelProperty(example = "IOS")
    @Nullable
    private String name;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public ObjectPatch() {
    }

}
