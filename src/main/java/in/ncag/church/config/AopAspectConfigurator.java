package in.ncag.church.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopAspectConfigurator {
		
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Before("execution(* com.ncag.church.*.*(..))")
		public void before(JoinPoint joinPoint){
			//Advice
			logger.info(" {} service Method Starts", joinPoint);
		}
		@After("execution(* com.ncag.church.*.*(..))")
		public void after(JoinPoint joinPoint){
			//Advice
			logger.info(" {} service Method ends", joinPoint);
		}
		
	}