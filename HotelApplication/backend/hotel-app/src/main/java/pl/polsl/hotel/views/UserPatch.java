package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.Nullable;


public class UserPatch {

    @ApiModelProperty(example = "John")
    @Nullable
    private String name;

    @ApiModelProperty(example = "Bosh", position = 1)
    @Nullable
    private String surname;

    @ApiModelProperty(example = "John33@gmail.com", position = 2)
    @Nullable
    private String email;


    @ApiModelProperty(example = "MAN", position = 3)
    @Nullable
    private String roleCode;

    @ApiModelProperty(hidden = true)
    private Boolean hasRoleCode = false;

    @ApiModelProperty(example = "admin1", position = 4)
    @Nullable
    private String password;

    public void setRoleCode(@Nullable String roleCode) {
        this.roleCode = roleCode;
        this.hasRoleCode = true;
    }

    public UserPatch() {
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getSurname() {
        return surname;
    }

    public void setSurname(@Nullable String surname) {
        this.surname = surname;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getRoleCode() {
        return roleCode;
    }

    public Boolean getHasRoleCode() {
        return hasRoleCode;
    }

    public void setHasRoleCode(Boolean hasRoleCode) {
        this.hasRoleCode = hasRoleCode;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPatch{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", hasRoleCode=" + hasRoleCode +
                ", password='" + password + '\'' +
                '}';
    }
}
