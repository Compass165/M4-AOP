package com.exception.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.exception.service.*.*(..))",throwing = "e")
    public void log (JoinPoint joinPoint, Exception e) {
        String className =joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Co loi xay ra: %s.%s%s: %s", className, methodName, args, e.getMessage()));
    }
}
