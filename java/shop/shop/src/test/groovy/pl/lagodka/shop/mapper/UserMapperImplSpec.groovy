package pl.lagodka.shop.mapper

import pl.lagodka.shop.model.dao.Role
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.model.dto.UserDto
import spock.lang.Specification

import java.time.LocalDateTime

class UserMapperImplSpec extends Specification{
    def userMapper = new UserMapperImpl()

    def "should map User to UserDto"(){
        given:
        def user = new User(1,"Jakub","Lagodka","kuba","password","mail@gmail.com",
                LocalDateTime.of(2022,1,6,13,30,50),"kuba",
                LocalDateTime.of(2022,1,5,12,40,50),"jan",[new Role(id: 1, name: "admin")])

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
}
