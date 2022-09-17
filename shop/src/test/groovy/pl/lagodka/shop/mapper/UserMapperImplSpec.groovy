package pl.lagodka.shop.mapper

import org.springframework.data.history.RevisionMetadata
import pl.lagodka.shop.model.dao.Role
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.model.dto.UserDto
import spock.lang.Specification

import java.time.LocalDateTime

class UserMapperImplSpec extends Specification {
    def userMapper = new UserMapperImpl()

    def 'should map user to userDto'() {
        given:
        def user = new User(1, "Jakub", "Lagodka", "kuba", "password", "mail@gmail.com",
                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan", [new Role(id: 1, name: "admin")])

        when:
        def result = userMapper.toDto(user)

        then:
        result.id == user.id
        result.confirmPassword == null
        result.createdBy == user.createdBy
        result.createdDate == user.createdDate
        result.firstName == user.firstName
        result.lastModifiedBy == user.lastModifiedBy
        result.lastModifiedDate == user.lastModifiedDate
        result.lastName == user.lastName
        result.login == user.login
        result.mail == user.mail
        result.password == null
        result.revisionNumber == null
        result.revisionType == null
    }

    def 'should map user to userDto return null'(){
        given:
        def user = null

        when:
        def result = userMapper.toDto(user)

        then:
        result == null
    }

    def 'should map userDto to user return null'(){
        given:
        def userDto = null

        when:
        def result = userMapper.toDao(userDto)

        then:
        result == null
    }

    def 'should map userDto to user'() {
        given:
        def userDto = new UserDto(1, "Jakub", "Lagodka", "kuba", "password", "password", "mail@gmail.com",
                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan",
                RevisionMetadata.RevisionType.DELETE, 0)
        when:
        def result = userMapper.toDao(userDto)

        then:
        result.id == userDto.id
        result.createdBy == userDto.createdBy
        result.createdDate == userDto.createdDate
        result.firstName == userDto.firstName
        result.lastModifiedBy == userDto.lastModifiedBy
        result.lastModifiedDate == userDto.lastModifiedDate
        result.lastName == userDto.lastName
        result.login == userDto.login
        result.mail == userDto.mail
        result.password == userDto.password
        result.roles == null
    }
}
