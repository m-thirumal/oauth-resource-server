/**
 * 
 */
package in.thirumal.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println(iAuthenticationFacade.getAuthentication().getName());
		return List.of(Order.builder().id(3).itemName("Working").orderDate(OffsetDateTime.now()).build());
	}
	
}
