package pl.polsl.hotelapp.models;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

public class Login {

    @ApiModelProperty(required = true, example = "admin")
    @NonNull
    private String username;

    @ApiModelProperty(required = true, example = "admin", position = 1)
    @NonNull
    private String password;

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }
}
