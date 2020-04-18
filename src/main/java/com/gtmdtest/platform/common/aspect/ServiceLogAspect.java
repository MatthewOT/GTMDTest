//package com.gtmdtest.platform.common.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///**
// * @program: platform
// * @description:
// * @author:
// * @create: 2020-01-06 14:14
// *
// * 注意，在切片方法内部，不能返回null，否则会造成service类内部mapper加载失败。
// * 为什么加载失败？这个是个待研究的点
// **/
//@Aspect
//@Component
//public class ServiceLogAspect {
//
//    @Pointcut("execution(public * com.gtmdtest.platform..*ServiceImpl.*(..))")
//    public void serviceImplPoint() {}
//
//    @Around("serviceImplPoint()")
//    public Object doServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        return null;
//    }
//
//}
