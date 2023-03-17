/**
 * 
 */
package in.thirumal.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Thirumal
 *
 */
//@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 
               // Make communication STATELESS
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
                // Configure antMatchers if needed
		http
		.authorizeHttpRequests()
		//.antMatchers("/orders/status/check").permitAll() // Public API endpoint
		.anyRequest()
                .authenticated();
	      //  .and()
	        //.oauth2ResourceServer()
	        //.jwt();
 
		http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt
                        .jwtAuthenticationConverter(new CustomAuthenticationConverter())
                    )
                );
		return http.build();
	}
	
	static class CustomAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
	    public AbstractAuthenticationToken convert(Jwt jwt) {
	    	Collection<String> authorities = jwt.getClaimAsStringList("roles");
	    	Collection<GrantedAuthority> grantedAuthorities = authorities.stream()
	                .map(SimpleGrantedAuthority::new)
	                .collect(Collectors.toList());
	    	return new JwtAuthenticationToken(jwt, grantedAuthorities);
	    }
	}
}
