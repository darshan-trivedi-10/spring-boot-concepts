package com.learning.spring_boot.aspectorientedprogramming;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingSecurityAspect {

    @Before("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..))")
    @Order(1)
    public void logBeforeMethod(JoinPoint joinPoint){
        System.out.println("[LOG] Method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.processPayment(..)) && args(userName, amount)")
    @Order(3)
    public void checkUserAuthorization(String userName, double amount){
        if ("hacker".equalsIgnoreCase(userName)){
            throw new SecurityException("[Security] Unauthorized user : " + userName);
        }
        System.out.println("[Security] User Authorized: " + userName);
    }

    @Before("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..)) && args(userName, amount)")
    @Order(2)
    public void validatePaymentAmount(String userName, double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be > 0");
        }
        System.out.println("Valid Amount : " + amount);
    }

    /********************************** After *******************************************/
    @After("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..))")
    public void logAfterMethod(JoinPoint joinPoint){
        System.out.println("[LOG] Method executed: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.processPayment(..)) && args(username, amount)")
    public void auditPaymentProcessing(String username, double amount) {
        System.out.println("[AUDIT] Payment of " + amount + " processed for user: " + username);
    }

    @After("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..))")
    public void cleanupResources(JoinPoint joinPoint) {
        System.out.println("[CLEANUP] Closing resources after executing: " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("[PERFORMANCE] Execution time for " + joinPoint.getSignature().getName() +
                ": " + (endTime - startTime) + " ms");
        return result;
    }

    @Around("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.*(..))")
    public Object logInputOutput(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("[LOG] Method: " + joinPoint.getSignature().getName() +
                " | Input: " + java.util.Arrays.toString(args));

        Object result = joinPoint.proceed();

        System.out.println("[LOG] Method: " + joinPoint.getSignature().getName() +
                " | Output: " + result);
        return result;
    }

    @Around("execution(* com.learning.spring_boot.aspectorientedprogramming.before.PaymentService.simulateError(..))")
    public Object handleExceptions(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("[ERROR] Exception in method: " + joinPoint.getSignature().getName() +
                    " | Message: " + ex.getMessage());
            return "An error occurred, please try again later.";
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Around("execution(* com.learning.spring_boot.scope.prototype.TransactionIdGenerator.*(..))")
    public Object hello(ProceedingJoinPoint proceedingJoinPoint){
        return new Object();
    }


    // 1️⃣ **@Within Example** - Logs every method inside PaymentService
    @Before("within(com.learning.spring_boot.aspectorientedprogramming.PaymentService)")
    public void logWithinPaymentService(JoinPoint joinPoint) {
        System.out.println("[WITHIN] Method inside PaymentService called: " + joinPoint.getSignature().getName());
    }

    // 2️⃣ **@Annotation Example** - Applies advice only to methods annotated with @TrackExecution
    @Before("@annotation(com.example.annotations.TrackExecution)")
    public void logAnnotatedMethods(JoinPoint joinPoint) {
        System.out.println("[ANNOTATION] Tracked execution for method: " + joinPoint.getSignature().getName());
    }

    // 1️⃣ **@AfterReturning Example** - Runs only when method is successful
    @AfterReturning(pointcut = "execution(* com.learning.spring_boot.aspectorientedprogramming.PaymentService.processPayment(..))", returning = "result")
    public void logAfterSuccessfulPayment(JoinPoint joinPoint, Object result) {
        System.out.println("[SUCCESS] Method: " + joinPoint.getSignature().getName() + " | Output: " + result);
    }

    // 2️⃣ **@AfterThrowing Example** - Runs only when method throws an exception
    @AfterThrowing(pointcut = "execution(* com.learning.spring_boot.aspectorientedprogramming.PaymentService.*(..))", throwing = "ex")
    public void logAfterException(JoinPoint joinPoint, Exception ex) {
        System.out.println("[ERROR] Exception in method: " + joinPoint.getSignature().getName() + " | Message: " + ex.getMessage());
    }
}
