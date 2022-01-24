package pl.lagodka.shop.validator.impl

import org.apache.commons.io.FilenameUtils
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
        multipartFile.getOriginalFilename() >> extension

        when:
        def result = fileValidator.isValid(multipartFile, null)

        then:
        result == expected

        where:
        extension || expected
        "file.jpg"     || true
        "file.png"     || true
        "file.txt"     || false
    }
}
