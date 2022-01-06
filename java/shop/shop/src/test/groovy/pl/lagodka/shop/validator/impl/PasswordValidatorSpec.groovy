package pl.lagodka.shop.validator.impl

import pl.lagodka.shop.model.dto.UserDto
import spock.lang.Specification

class PasswordValidatorSpec extends Specification {
    def passwordValidator = new PasswordValidator()

    def 'should test password validator'() {
        given:
        def userDto = new UserDto(password: password, confirmPassword: confirmPassword)

        when:
        def result = passwordValidator.isValid(userDto, null)

        then:
        result == expected

        where:
        password   | confirmPassword || expected
        "pass"     | "password"      || false
        "password" | "password"      || true
    }
}
