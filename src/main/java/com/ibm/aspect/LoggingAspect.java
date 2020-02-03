package com.ibm.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.ibm.service.NoteServiceImpl.deleteNote(..))")
	public void deleteNote() {
	}

	@Before("execution(* com.ibm.service.NoteServiceImpl.addNote(..))")
	public void logBerforeAddingNote(JoinPoint joinPoint) {
		logger.info("=========Before Add Note==========");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		logger.debug("Advice applied at " + className + ":" + methodName);
	}

	@Before("deleteNote()")
	public void logBerforeDeletingNote(JoinPoint joinPoint) {
		logger.info("=========Before Delete Note==========");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		logger.debug("Advice applied at " + className + ":" + methodName);
	}

	@AfterReturning(pointcut = "deleteNote()", returning = "result")
	public void logAfterDeletingNote(JoinPoint joinPoint) {
		logger.info("=========After Delete Note==========");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		logger.debug("Advice applied after " + className + ":" + methodName);
		logger.info("====================");
	}

	@AfterThrowing(pointcut = "deleteNote()", throwing = "exp")
	public void logAfterExceptionDeletingNote(JoinPoint joinPoint, Throwable exp) {
		logger.info("=========After Delete Note Error==========");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getSignature().getDeclaringTypeName();
		logger.debug("Advice applied after " + className + ":" + methodName);
		logger.info("Method Args:" + Arrays.toString(joinPoint.getArgs()));
		logger.error("Delete failed", exp);
	}

}
