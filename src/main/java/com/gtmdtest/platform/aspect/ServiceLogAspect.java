package com.gtmdtest.platform.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2020-01-06 14:14
 **/
@Aspect
@Component
public class ServiceLogAspect {

    @Pointcut("execution(public * com.gtmdtest.platform..*ServiceImpl.*(..))")
    public void serviceImplPoint() {}

    @Around("serviceImplPoint()")
    public Object doServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {

        return null;
    }

}
