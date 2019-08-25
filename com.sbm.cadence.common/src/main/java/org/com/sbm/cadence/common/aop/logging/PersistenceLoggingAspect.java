package org.com.sbm.cadence.common.aop.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
@Aspect
@Configuration
public class PersistenceLoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.persistenceExecution()")
	public void beforePersistence(JoinPoint joinPoint) {
		logger.info(" **************** Start {} **************** ", joinPoint.toString());
		logger.info(" **************** Params passed = {} **************** ", Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.persistenceExecution()")
	public void afterPersistence(JoinPoint joinPoint) throws Throwable {
		logger.info(" **************** Finish {} **************** ", joinPoint.toString());
	}
	
	@Around("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.persistenceExecution()")
	public Object aroundPersistence(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;		
		result = joinPoint.proceed();
		logger.info("The result of " 
				+ joinPoint.getSignature().getDeclaringType().getSimpleName() 
				+ " class in " + joinPoint.getSignature().getName() 
				+ " method is : {}", result);
		return result;
	}
}
