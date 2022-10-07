package pl.lagodka.shop.service.impl


import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import pl.lagodka.shop.model.dto.LoginDto
import spock.lang.Specification

class LoginServiceImplSpec extends Specification {
    def authenticationManager = Mock(AuthenticationManager)
    def loginService = new LoginServiceImpl(authenticationManager)

    def 'should login'() {
        given:
        def loginDto = new LoginDto("admin", "admin")
        def usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)

        when:
        loginService.login(loginDto)

        then:
        1 * authenticationManager.authenticate(usernamePasswordAuthenticationToken) >> authentication
        1 * authentication.getName() >> "admin"
        1 * authentication.getAuthorities() >> Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"))
        0 * _
    }
}
