/**
 * 
 */
package in.thirumal.controller;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.thirumal.model.Order;
import in.thirumal.security.IAuthenticationFacade;

/**
 * @author Thirumal
 *
 */
@RestController
public class OrderController {

	@Autowired
	IAuthenticationFacade iAuthenticationFacade;
	
	@GetMapping("/orders")
	public List<Order> getOrder() {
		return List.of(Order.builder().id(3).itemName("Working").orderDate(OffsetDateTime.now()).build());
	}
	
	
	/**
	 * Accessing JWT claim details
	 * @param jwt
	 * @return Map
	 */
	@GetMapping("/token")
	public Map<String, Jwt> getToken(@AuthenticationPrincipal Jwt jwt) {
		return Collections.singletonMap("principal", jwt);
	}
	
}
