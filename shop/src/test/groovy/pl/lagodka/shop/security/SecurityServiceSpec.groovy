package pl.lagodka.shop.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.repository.UserRepository
import pl.lagodka.shop.service.UserService
import pl.lagodka.shop.service.impl.UserServiceImpl
import spock.lang.Specification

class SecurityServiceSpec extends Specification {
    def userService = Mock(UserService)
    def securityService = new SecurityService(userService)

    def 'should check if has access to user'() {
        given:
        def id = 1
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)
        def userRepository = Mock(UserRepository)
        def user = new User(id : id)
        userService.getCurrentUser() >> user

        when:
        def result = securityService.hasAccessToUser(id)

        then:
//        1 * securityContext.getAuthentication() >> authentication
//        1 * authentication.getName() >> "kuba"
//        1 * SecurityUtils.getCurrentUserLogin() >> "kuba"
//        1 * userService.getCurrentUser()
//        1 * userRepository.findByLogin("kuba") >> Optional.of(new User())
//        1 * user.getId() >> id
//        1 * user.getId().equals(id)
//        0 * _
        result
    }
}
