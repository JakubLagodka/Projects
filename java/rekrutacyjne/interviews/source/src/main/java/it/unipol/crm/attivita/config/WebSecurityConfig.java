package it.unipol.crm.attivita.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${ENABLE_TEST_ENDPOINTS}")
    private boolean enableTestEndpoints;

    @Override
    public void configure(WebSecurity web) {
        if (enableTestEndpoints) {
            web.ignoring().antMatchers(
                    "/swagger-resources/**",
                    "/swagger-ui.html",
                    "/swagger-ui/**",
                    "/v2/api-docs",
                    "/actuator/**",
                    "/webjars/**");
        } else {
            web.ignoring().antMatchers("/actuator/health");
        }
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

}