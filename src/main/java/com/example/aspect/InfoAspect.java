package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InfoAspect {

    @Before("execution(* findAllShipwrecks(..))")
    public void entering(JoinPoint joinPoint) {
        System.out.println("Entering: " + joinPoint.getStaticPart().getSignature().toString());
    }

    @After("execution(* findAllShipwrecks(..))")
    public void exiting(JoinPoint joinPoint) {
        System.out.println("Exiting: " + joinPoint.getSignature().toString());
    }

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
    public void logException(RuntimeException ex) {
        System.out.println("Exception thrown: " + ex.getMessage());
    }
}
