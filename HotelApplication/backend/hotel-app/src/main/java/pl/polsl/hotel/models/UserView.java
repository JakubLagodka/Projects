package pl.polsl.hotel.models;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


public class UserView {

    @ApiModelProperty(required = true)
    @NonNull
    private Long id;

    @ApiModelProperty(required = true, example = "John", position = 1)
    @NonNull
    private String name;

    @ApiModelProperty(required = true, example = "Bosh", position = 2)
    @NonNull
    private String surname;

    @ApiModelProperty(required = true, example = "John33@gmail.com", position = 3)
    @NonNull
    private String email;

    @ApiModelProperty(required = true, example = "John33", position = 4)
    @NonNull
    private String username;

    @ApiModelProperty(example = "ADM", position = 5)
    @Nullable
    private String roleCode;

    public UserView() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
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

    @Nullable
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(@Nullable String roleCode) {
        this.roleCode = roleCode;
    }
}
