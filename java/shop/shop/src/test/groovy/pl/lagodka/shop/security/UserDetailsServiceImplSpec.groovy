package pl.lagodka.shop.security

import pl.lagodka.shop.repository.UserRepository
import spock.lang.Specification

class UserDetailsServiceImplSpec extends Specification {

    def userDetailsServiceImpl = Mock(UserDetailsServiceImpl)

    def 'should load user by username'() {
        given:
        def username = "kuba"
        def userRepository = Mock(UserRepository)

        when:
        userDetailsServiceImpl.loadUserByUsername(username)

        then:
        1 * userRepository.findByLoginOrMail(username, username)
        0 * _
    }
}
