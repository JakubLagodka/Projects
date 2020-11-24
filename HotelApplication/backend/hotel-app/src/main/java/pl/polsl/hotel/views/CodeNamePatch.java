package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public class CodeNamePatch {

    @ApiModelProperty(example = "Programming")
    @Nullable
    private String name;

    public CodeNamePatch() {
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CodeNamePatch{" +
                "name='" + name + '\'' +
                '}';
    }
}
