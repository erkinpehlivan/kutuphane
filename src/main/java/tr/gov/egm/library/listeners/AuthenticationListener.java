package tr.gov.egm.library.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;

@WebListener
public class AuthenticationListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
	
	@Autowired
	HttpSession session;

	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {

		UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
		session.setAttribute("username", userDetails.getUsername());
		System.out.println("SESSION => "+session);


	}

}
