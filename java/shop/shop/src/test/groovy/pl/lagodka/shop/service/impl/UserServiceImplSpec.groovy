package pl.lagodka.shop.service.impl

import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.password.PasswordEncoder
import pl.lagodka.shop.model.dao.Role
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.repository.RoleRepository
import pl.lagodka.shop.repository.UserRepository
import spock.lang.Specification

class UserServiceImplSpec extends Specification {
    def userRepository = Mock(UserRepository)
    def passwordEncoder = Mock(PasswordEncoder)
    def roleRepository = Mock(RoleRepository)
    def userService = new UserServiceImpl(userRepository, passwordEncoder, roleRepository)

    def 'should return user by id'() {
        given:
        def id = 1

        when:
        userService.getById(id)

        then:
        1 * userRepository.getById(id)
        0 * _
    }

    def 'should delete user'() {
        given:
        def id = 1

        when:
        userService.delete(id)

        then:
        1 * userRepository.deleteById(id)
        0 * _
    }

    def 'should return page of users'() {
        given:
        def pageable = Mock(Pageable)

        when:
        userService.getPage(pageable)

        then:
        1 * userRepository.findAll(pageable)
        0 * _
    }

    def 'should save user'() {
        given:
        def user = Mock(User)
        def role = new Role(id: 1, name: "user")

        when:
        userService.create(user)

        then:
        1 * user.getPassword() >> "password"
        1 * passwordEncoder.encode("password") >> "haslo"
        1 * user.setPassword("haslo")
        1 * roleRepository.findByName("ROLE_USER") >> Optional.of(role)
        1 * user.setRoles(Collections.singletonList(role))
        1 * userRepository.save(user)
        0 * _
    }

    def 'should update user'() {
        given:
        def user = Mock(User)
        def id = 1
        def userDb = Mock(User)

        when:
        userService.update(user, id)

        then:
        1 * userService.getById(id)
        1 * user.getFirstName()
        1 * userDb.setFirstName("Jakub")
        1 * user.getLastName()
        1 * userDb.setLastName("Lagodka")
        0 * _
    }
}
