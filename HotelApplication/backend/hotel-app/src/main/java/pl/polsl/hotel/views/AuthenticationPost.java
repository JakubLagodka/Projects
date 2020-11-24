package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;


public class AuthenticationPost {

    @ApiModelProperty(required = true, example = "admin")
    @NonNull
    private String username;

    @ApiModelProperty(required = true, example = "admin", position = 1)
    @NonNull
    private String password;

    public AuthenticationPost() {
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationPost{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
