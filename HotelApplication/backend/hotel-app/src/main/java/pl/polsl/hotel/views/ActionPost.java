package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public abstract class ActionPost {

    @ApiModelProperty(example = "Fix integer types")
    @Nullable
    private String description;

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public ActionPost() {
    }

    @Override
    public String toString() {
        return "ActionPost{" +
                "description='" + description + '\'' +
                '}';
    }
}
