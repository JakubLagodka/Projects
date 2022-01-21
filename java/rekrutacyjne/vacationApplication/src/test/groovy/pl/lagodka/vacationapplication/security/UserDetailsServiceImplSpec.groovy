package pl.lagodka.vacationapplication.security

import pl.lagodka.vacationapplication.model.dao.Role
import pl.lagodka.vacationapplication.model.dao.User
import pl.lagodka.vacationapplication.repository.UserRepository
import spock.lang.Specification

class UserDetailsServiceImplSpec extends Specification {

    def userRepository = Mock(UserRepository)
    def userDetailsServiceImpl = new UserDetailsServiceImpl(userRepository)

    def 'should load user by username'() {
        given:
        def username = "kuba"
        def user = new User(login:"login",password: "password", roles: Arrays.asList(new Role(name: "user")))
      //  user.getRoles() >> Arrays.asList(new Role())

        when:
        userDetailsServiceImpl.loadUserByUsername(username)

        then:
        1 * userRepository.findByLoginOrMail(username, username) >> Optional.of(user)
        0 * _
    }
}
