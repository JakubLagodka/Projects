package pl.lagodka.shop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldErrorDto {
    private String fieldName;

    private String message;
}
