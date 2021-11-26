package pl.lagodka.shop.validator.impl;

import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.validator.PasswordValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValid, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
       return userDto.getPassword().equals(userDto.getConfirmPassword());
    }
}
