package pl.lagodka.shop.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import spock.lang.Specification

class AuditorAwareImplSpec extends Specification{
    def auditorAwareImpl = new AuditorAwareImpl()

    def 'should return current auditor'(){
        given:
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)

        when:
        auditorAwareImpl.getCurrentAuditor()

        then:
        1 * securityContext.getAuthentication() >> authentication
        1 * authentication.getName() >> "kuba"
        1 * SecurityUtils.getCurrentUserLogin() >> "kuba"
        0 * _

    }
}
