package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@ToString
public class ObjectView {

    @ApiModelProperty(required = true)
    @NonNull
    private Long id;

    @ApiModelProperty(required = true, example = "IOS", position = 1)
    @Nullable
    private String name;

    @ApiModelProperty(required = true, example = "PRG", position = 2)
    @NonNull
    private String objectTypeCode;

    @ApiModelProperty(required = true, position = 3)
    @NonNull
    private Long clientId;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
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
