package pl.lagodka.hotel.configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.lagodka.hotel.service.AuthenticationTokenService;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ModifiedOncePerRequestFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final AuthenticationTokenService authenticationTokenService;
    protected final Logger log = Logger.getLogger(getClass().getName());

    public ModifiedOncePerRequestFilter(ModifiedUserDetailsService userDetailsService, AuthenticationTokenService authenticationTokenService) {
        this.userDetailsService = userDetailsService;
        this.authenticationTokenService = authenticationTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            final String token = request.getHeader("Authorization");
            String username = authenticationTokenService.getUsernameFromToken(token);
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (authenticationTokenService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        } catch (Exception e) {
            log.log(Level.INFO, "Token filter exception = " + e.getClass().getName() + " - " + e.getMessage());
            // System.out.println("Token filter exception = " + e.getClass().getName() + " - " + e.getMessage());
        }
        chain.doFilter(request, response);
    }
}
