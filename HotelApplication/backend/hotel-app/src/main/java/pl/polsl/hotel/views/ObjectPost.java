package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@ToString
public class ObjectPost {

    @ApiModelProperty(required = true, example = "IOS")
    @NonNull
    private String name;

    @ApiModelProperty(required = true, example = "PRG", position = 1)
    @NonNull
    private String objectTypeCode;

    @ApiModelProperty(required = true, position = 2)
    @NonNull
    private Long clientId;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getObjectTypeCode() {
        return objectTypeCode;
    }

    public void setObjectTypeCode(@NonNull String objectTypeCode) {
        this.objectTypeCode = objectTypeCode;
    }

    @NonNull
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(@NonNull Long clientId) {
        this.clientId = clientId;
    }
}
