package pl.lagodka.hotel.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import pl.lagodka.hotel.repository.UserRepository
import spock.lang.Specification

class AuditorAwareImplSpec extends Specification {
    def auditorAwareImpl = new AuditorAwareImpl()

    def 'should return current auditor'() {
        given:
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)
        def userRepository = Mock(UserRepository)
//        SecurityUtils.getCurrentUserLogin() >> "user"
        when:
        def result = auditorAwareImpl.getCurrentAuditor()

        then:
//        1 * securityContext.getAuthentication() >> authentication
//        1 * authentication.getName() >> "kuba"
//        1 * userRepository.findByLogin("kuba") >> Optional.of(new User())
//        1 * SecurityUtils.getCurrentUserLogin()
//        0 * _
        result == Optional.ofNullable(null)
    }
}
