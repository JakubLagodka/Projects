package pl.lagodka.shop.service.impl

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.DefaultClaims
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.core.GrantedAuthorityDefaults
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import pl.lagodka.shop.model.dao.Basket
import pl.lagodka.shop.model.dao.Product
import pl.lagodka.shop.model.dto.LoginDto
import spock.lang.Specification
import org.springframework.security.authentication.AuthenticationManager;

class LoginServiceImplSpec extends Specification {
    def authenticationManager = Mock(AuthenticationManager)
    def loginService = new LoginServiceImpl(authenticationManager)

    def 'should login'() {
        given:
        def loginDto = new LoginDto("admin", "admin")
        def usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        def claims = new DefaultClaims()
        def authentication = Mock(Authentication)

        when:
        loginService.login(loginDto)

        then:
        1 * authenticationManager.authenticate(usernamePasswordAuthenticationToken) >> authentication
        1 * new DefaultClaims().setSubject(authentication.getName()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        1 * authentication.getName()
        1 * claims.put("authorities")
        1 * authentication.getAuthorities() >> Arrays.asList(new GrantedAuthorityDefaults("user"))
        1 * Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "password").compact()
        0 * _
    }
}
