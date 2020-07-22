package com.demo;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Aspect for logging execution of service and repository Spring components.
 * @author Ramesh Fadatare
 *
 */
@Aspect
@Component
public class LoggingAspect {

     private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.demo.controller.GreetingController.home(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        LOGGER.info(" Check for user access ");
        LOGGER.info(" Allowed execution for {}", joinPoint);

        LOGGER.info("[{}]-[{}]",joinPoint.getSignature().getName(), Arrays.asList(((MethodSignature) joinPoint.getSignature()).getParameterNames()));
    }

    @After("execution(* com.demo.controller.GreetingController.home(..))")
    public void logAfter(JoinPoint joinPoint) {

        LOGGER.info("logAfter() is running!");
        LOGGER.info("hijacked : " + joinPoint.getSignature().getName());
        LOGGER.info("******");

    }

    @AfterReturning(pointcut = "execution(* com.demo.controller.GreetingController.home(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        try {
        LOGGER.info("logAfterReturning() is running!");
        LOGGER.info("hijacked : " + joinPoint.getSignature().getName());
        LOGGER.info("Method returned value is : " + result);
        LOGGER.info("******");
        }catch (Exception e){
            LOGGER.error("Exception",e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @AfterThrowing(pointcut = "execution(* com.demo.controller.GreetingController.home(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        try {
            LOGGER.info("logAfterThrowing() is running!");
            LOGGER.info("hijacked : " + joinPoint.getSignature().getName());
            LOGGER.info("Exception : " + error);
            LOGGER.info("******");
        }catch (Exception e){
            LOGGER.error("Exception",e);
            throw new RuntimeException(e.getMessage());
        }


    }



    @Around("execution(* com.demo.controller.GreetingController.home(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

       LOGGER.info("Inside RunBeforeExecution.before() method...");
       LOGGER.info("Running before advice...");
        try{
            Object result = joinPoint.proceed();
               LOGGER.info("Inside RunAfterExecution.afterReturning() method...");
               LOGGER.info("Running after advice...");
            return result;
        } catch(Exception e){
            LOGGER.error("Exception",e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
