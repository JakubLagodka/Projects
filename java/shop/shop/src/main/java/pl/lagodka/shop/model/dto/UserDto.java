package pl.lagodka.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    private String password;
}
