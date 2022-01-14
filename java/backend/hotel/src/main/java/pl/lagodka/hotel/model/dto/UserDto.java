package pl.lagodka.hotel.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.history.RevisionMetadata;
import pl.lagodka.hotel.validator.PasswordValid;
import pl.lagodka.hotel.validator.group.Create;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@PasswordValid(message = "password and config password should be the same", groups = Create.class)

public class UserDto {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String login;

    @NotBlank(groups = Create.class)
    private String password;

    private String confirmPassword;
    @Email
    @NotBlank
    private String mail;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime lastModifiedDate;

    private String lastModifiedBy;

    private RevisionMetadata.RevisionType revisionType;

    private Integer revisionNumber;
}
