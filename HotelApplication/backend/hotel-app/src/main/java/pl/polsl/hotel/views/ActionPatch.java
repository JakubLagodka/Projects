package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public abstract class ActionPatch {

    @ApiModelProperty(example = "Fix integer types")
    @Nullable
    private String description;

    @ApiModelProperty(hidden = true)
    private Boolean hasDescription = false;

    public void setDescription(@Nullable String description) {
        this.description = description;
        this.hasDescription = true;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public Boolean getHasDescription() {
        return hasDescription;
    }

    public ActionPatch() {
    }

    @Override
    public String toString() {
        return "ActionPatch{" +
                "description='" + description + '\'' +
                ", hasDescription=" + hasDescription +
                '}';
    }
}
