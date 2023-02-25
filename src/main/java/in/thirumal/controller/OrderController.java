/**
 * 
 */
package in.thirumal.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.thirumal.model.Order;

/**
 * @author Thirumal
 *
 */
@RestController
public class OrderController {

	
	@GetMapping("/orders")
	public List<Order> getOrder() {
		return List.of(Order.builder().id(3).itemName("Working").orderDate(OffsetDateTime.now()).build());
	}
	
}
