package pl.lagodka.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import pl.lagodka.shop.validator.PasswordValid;
import pl.lagodka.shop.validator.group.Create;

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
}
