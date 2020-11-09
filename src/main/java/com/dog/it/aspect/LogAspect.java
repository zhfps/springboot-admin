package com.dog.it.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.dog.it.service.*.*(..))")
    public void pc1(){

    }

    @Before(value = "pc1()")
    public void before(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName());
        log.info("开始执行");
    }

    @After(value = "pc1()")
    public void after(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName());
        log.info("执行完毕");
    }

    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        log.info(joinPoint.getSignature().getName());
        log.info("返回了:");
        log.info(result.toString());
    }

    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrow(JoinPoint joinPoint,Exception e){
        log.info(joinPoint.getSignature().getName());
        log.info("抛异常了:");
        log.info(e.getMessage());
    }

    @Around(value = "pc1()")
    public Object afterThrow(ProceedingJoinPoint pip) throws Throwable {
        return pip.proceed();
    }

}
