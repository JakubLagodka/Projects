package pl.lagodka.shop.security


import pl.lagodka.shop.model.dao.User
import pl.lagodka.shop.service.UserService
import spock.lang.Specification

class SecurityServiceSpec extends Specification {
    def userService = Mock(UserService)
    def securityService = new SecurityService(userService)

    def 'should check if has access to user'() {
        given:
        def id = 1
        def user = new User(id: id)

        when:
        securityService.hasAccessToUser(id)

        then:

        1 * userService.getCurrentUser() >> user
        0 * _
    }
}
