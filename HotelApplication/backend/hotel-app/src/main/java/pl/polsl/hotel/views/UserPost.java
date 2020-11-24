package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


public class UserPost {

    @ApiModelProperty(required = true, example = "John")
    @NonNull
    private String name;

    @ApiModelProperty(required = true, example = "Bosh", position = 1)
    @NonNull
    private String surname;

    @ApiModelProperty(required = true, example = "JohnBosh33@gmail.com", position = 2)
    @NonNull
    private String email;

    @ApiModelProperty(required = true, example = "admin", position = 3)
    @NonNull
    private String username;

    @ApiModelProperty(required = true, example = "admin", position = 4)
    @NonNull
    private String password;

    @ApiModelProperty(required = true, example = "admin", position = 4)
    @Nullable
    private String roleCode;

    public UserPost() {
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
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

    @Nullable
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(@Nullable String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "UserPost{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
