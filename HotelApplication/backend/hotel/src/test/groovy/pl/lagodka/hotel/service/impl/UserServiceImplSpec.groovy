package pl.lagodka.hotel.service.impl

import org.springframework.data.domain.Pageable
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import pl.lagodka.hotel.model.dao.Role
import pl.lagodka.hotel.model.dao.User
import pl.lagodka.hotel.repository.RoleRepository
import pl.lagodka.hotel.repository.UserRepository
import spock.lang.Specification

class UserServiceImplSpec extends Specification{
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
        1 * userRepository.getById(id) >> userDb
        1 * user.getFirstName() >> "Jakub"
        1 * userDb.setFirstName("Jakub")
        1 * user.getLastName() >> "Lagodka"
        1 * userDb.setLastName("Lagodka")
        0 * _
    }

    def 'should get current user'() {
        given:
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)


        when:
        userService.getCurrentUser()

        then:
        1 * securityContext.getAuthentication() >> authentication
        1 * authentication.getName() >> "kuba"
        1 * userRepository.findByLogin("kuba") >> Optional.of(new User())
        0 * _
    }
}
