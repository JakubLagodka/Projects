package pl.lagodka.shop.validator.impl

import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.commons.CommonsMultipartFile
import pl.lagodka.shop.model.dto.UserDto
import spock.lang.Specification

class FileValidatorSpec extends Specification {
    def fileValidator = new FileValidator()

    def 'should test file validator'() {
        given:
        def multipartFile = Mock(MultipartFile)
       // extension: extension
        when:
        def result = fileValidator.isValid(multipartFile, null)

        then:
        result == expected

        where:
        extension || expected
        "jpg"     || true
        "png"     || true
        "txt"     || false
    }
}
