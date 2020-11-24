package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;


public class CodeNameView {

    @ApiModelProperty(example = "PRG")
    @NonNull
    private String code;

    @ApiModelProperty(example = "Programming", position = 1)
    @NonNull
    private String name;

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

    public CodeNameView() {
    }

    @Override
    public String toString() {
        return "CodeNameView{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

