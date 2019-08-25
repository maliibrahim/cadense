package org.com.sbm.cadence.common.aop.config;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public final class AOPJoinPointConfig {
	
	@Pointcut("execution(* org.com.sbm.cadence.presentation.controllers.*.*(..))")
	public void controllerExecution() {}
	
	@Pointcut("execution(* org.com.sbm.cadence.service.facades.*.*(..))")
	public void facadeExecution() {}
	
	@Pointcut("execution(* org.com.sbm.cadence.service.implementation.*.*(..))")
	public void serviceExecution() {}
	
	@Pointcut("execution(* org.com.sbm.cadence.persistence.repositories.*.*(..))")
	public void persistenceExecution() {}
	
	@Pointcut("execution(* org.com.sbm.cadence.be.integration.*.*(..))")
	public void integrationExecution() {}
	
	@Pointcut("execution(* org.com.sbm.cadence.common.exceptions.*.*(..))")
	public void exceptionExecution() {}
}