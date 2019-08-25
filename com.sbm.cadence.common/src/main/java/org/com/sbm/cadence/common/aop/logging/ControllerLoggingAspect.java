package org.com.sbm.cadence.common.aop.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Haythem Alshaikh
 *
 */
@Aspect
@Configuration
public class ControllerLoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.controllerExecution()")
	public void beforeController(JoinPoint joinPoint) {
		logger.info(" **************** Start {} **************** ",
				joinPoint.toString());
		logger.info(" **************** Params passed = {} **************** ",
				Arrays.toString(joinPoint.getArgs()));
	}

	@After("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.controllerExecution()")
	public void afterController(JoinPoint joinPoint) {
		logger.info(" **************** Finish {} **************** ",
				joinPoint.toString());
	}

	@Around("org.com.sbm.cadence.common.aop.config.AOPJoinPointConfig.controllerExecution()")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;		
		result = joinPoint.proceed();
		logger.info("The result of " 
				+ joinPoint.getSignature().getDeclaringType().getSimpleName() 
				+ " class in " + joinPoint.getSignature().getName() 
				+ " method is : {}", result);
		return result;
	}
}