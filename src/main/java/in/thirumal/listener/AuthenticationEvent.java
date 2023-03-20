/**
 * 
 */
package in.thirumal.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author Thirumal
 *
 */
@Component
public class AuthenticationEvent {

	Logger logger = LoggerFactory.getLogger(AuthenticationEvent.class);

	// Refer https://docs.spring.io/spring-security/reference/servlet/authentication/events.html#servlet-events
	
	@EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
		String loginUser = success.getAuthentication().getName();
		logger.debug("Success login event for  {} ", loginUser);
	
    }
}
