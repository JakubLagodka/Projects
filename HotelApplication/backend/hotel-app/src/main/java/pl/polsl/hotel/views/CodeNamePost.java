package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@ToString
public class CodeNamePost {

    @ApiModelProperty(example = "PRG")
    @NonNull
    private String code;

    @ApiModelProperty(example = "Programming", position = 1)
    @NonNull
    private String name;

}
