//package com.gtmdtest.platform.aspect;
//
//import cn.hutool.log.Log;
//import com.alibaba.fastjson.JSON;
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
//        long startTime = System.currentTimeMillis();
//
//        Object[] params = joinPoint.getArgs();
//        LogBuffer lb1 = LogBuffer.create(null);
//        lb1.append("className", joinPoint.getSignature().getDeclaringTypeName());
//        lb1.append("methodName", joinPoint.getSignature().getName());
//        lb1.append("params", JSON.toJSONString(params));
//        Log.info(lb1.toString());
//        Object result = joinPoint.proceed();
//        LogBuffer lb2 = LogBuffer.create(null);
//        lb2.append("className", joinPoint.getSignature().getDeclaringTypeName());
//        lb2.append("methodName", joinPoint.getSignature().getName());
//        lb2.append("result", JSON.toJSONString(result));
//        lb2.append("耗时", (System.currentTimeMillis() - startTime) + "(ms)");
//        Log.info(lb2.toString());
//        return result;
//    }
//
//}
