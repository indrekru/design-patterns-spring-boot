package com.investly.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
@Aspect
@Component
public class AroundGetContactsAspect {

	@Pointcut("execution(* com.investly.service.BankService.*(..))")
	public void exampleService() {}

	@Around("exampleService()")
	public Object profile(ProceedingJoinPoint pjp) {
		LocalDateTime start = LocalDateTime.now();
		Object task = null;
		try {
			task = pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		LocalDateTime end = LocalDateTime.now();
		Duration duration = Duration.between(start, end);
		System.out.println("Execution took: " + duration.toMillis() + " ms");
		return task;
	}

}
