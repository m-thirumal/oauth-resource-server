/**
 * 
 */
package in.thirumal.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * @author Thirumal
 *
 */
@Component
public class FailureEvents {
	
	Logger logger = LoggerFactory.getLogger(FailureEvents.class);

	@EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent badCredentials) {
		if (badCredentials.getAuthentication() instanceof BearerTokenAuthenticationToken) {
		  logger.warn("The requested token is invalid");
        }
    }
	
}
