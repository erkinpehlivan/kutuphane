package tr.gov.egm.library.listeners;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent> {

	@Autowired
	private HttpSession session;
	
	@Override
	public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
		if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent || authenticationEvent instanceof AuthenticationSuccessEvent) {
			System.out.println(session);
		} else if (authenticationEvent instanceof AbstractAuthenticationFailureEvent) {
			System.out.println(session);
		}
	}
}
