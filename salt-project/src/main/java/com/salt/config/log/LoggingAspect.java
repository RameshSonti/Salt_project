package com.salt.config.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * Log method entry.
	 * 
	 * @param joinPoint
	 */
	@Pointcut("within(com.salt*)")
	public void logEntry(final JoinPoint joinPoint) {
		log("Entering method " + joinPoint.getSignature().getName() + "...");
	}

	/**
	 * Log method exit.
	 * 
	 * @param joinPoint
	 */
	@Pointcut("within(com.salt*)")
	public void logExit(final JoinPoint joinPoint) {
		log("Exiting method " + joinPoint.getSignature().getName() + ".");
	}

	/**
	 * Log method exit after returning.
	 * 
	 * @param joinPoint
	 */
	@Pointcut("within(com.salt*)")
	public void logExitAfterReturn(final JoinPoint joinPoint) {
		log("Exiting method (after return) " + joinPoint.getSignature().getName() + ".");
	}

	/**
	 * Advice that logs methods throwing exceptions.
	 *
	 * @param joinPoint join point for advice
	 * @param e         exception
	 */
	@AfterThrowing(pointcut = "logEntry() &&logExit() && logExitAfterReturn()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		LOGGER.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}

	/**
	 * "Log" the provided String.
	 * 
	 * @param messageToLog String to be logged.
	 * @throws Throwable
	 */

	@Around("logEntry() && logEntry() && logExitAfterReturn()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		}
		try {
			Object result = joinPoint.proceed();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
						joinPoint.getSignature().getName(), result);
			}
			return result;
		} catch (IllegalArgumentException e) {
			LOGGER.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw e;
		}
	}
	private static void log(final String messageToLog) {
		LOGGER.debug(messageToLog);
	}
}
