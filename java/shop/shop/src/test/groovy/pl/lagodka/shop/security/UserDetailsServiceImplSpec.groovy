package pl.lagodka.shop.security

import pl.lagodka.shop.repository.UserRepository
import spock.lang.Specification

class UserDetailsServiceImplSpec extends Specification {

    def userDetailsServiceImpl = Mock(UserDetailsServiceImpl)

    def 'should load user by username'() {
        given:
        def username = "kuba"
        def userRepository = Mock(UserRepository)

        then:
        userDetailsServiceImpl.loadUserByUsername(username)

        when:
        1 * userRepository.findByLoginOrMail(username, username)
        1*
    }
}
