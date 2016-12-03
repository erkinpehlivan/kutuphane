package tr.gov.egm.library.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdviceAspect {

	@Before("pointcut")
	public void openSession() {

	}

	@After("pointcut")
	public void closeSession() {

	}

	@Pointcut("within(tr.gov.egm.library.dao)")
	public void pointcut() {
	}
}