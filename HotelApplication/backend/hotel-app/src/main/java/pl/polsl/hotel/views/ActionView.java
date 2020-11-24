package pl.polsl.hotel.views;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;


public abstract class ActionView {

    @ApiModelProperty(required = true)
    @NonNull
    private Long id;

    @ApiModelProperty(example = "There is problem with...", position = 1)
    @Nullable
    private String description;

    @ApiModelProperty(required = true, example = "OPN", position = 2)
    @NonNull
    private String statusCode;

    @ApiModelProperty(example = "Done!", position = 3)
    @Nullable
    private String result;

    @ApiModelProperty(required = true, position = 4)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NonNull
    private Date registerDate;

    @ApiModelProperty(position = 5)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Nullable
    private Date endDate;

    public ActionView() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @NonNull
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(@NonNull String statusCode) {
        this.statusCode = statusCode;
    }

    @Nullable
    public String getResult() {
        return result;
    }

    public void setResult(@Nullable String result) {
        this.result = result;
    }

    @NonNull
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@NonNull Date registerDate) {
        this.registerDate = registerDate;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ActionView{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", result='" + result + '\'' +
                ", registerDate=" + registerDate +
                ", endDate=" + endDate +
                '}';
    }
}
