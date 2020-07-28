package com.java.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class HAspect {
	public static Logger logger = Logger.getLogger(HAspect.class.getName());
	public static final String logMsg = "===========LogMsg==============";
	
	
	
	public Object advice(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		
		try {
			
			logger.info(logMsg + joinPoint.getTarget().getClass().getName()+"===="+ joinPoint.getSignature().getName());
			
			obj = joinPoint.proceed();
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
