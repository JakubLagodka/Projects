package pl.lagodka.hotel.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import pl.lagodka.hotel.model.dao.User
import pl.lagodka.hotel.service.UserService
import spock.lang.Specification

class SecurityServiceSpec extends Specification{
    def userService = Mock(UserService)
    def securityService = new SecurityService(userService)

    def 'should check if has access to user'() {
        given:
        def id = 1
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)
        def user = new User(id : id)
        userService.getCurrentUser() >> user

        when:
        def result = securityService.hasAccessToUser(id)

        then:
        result
    }
}
