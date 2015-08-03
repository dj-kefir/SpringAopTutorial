package ru.oz.srpingaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SimpleServiceAspect {

    // http://www.captaindebug.com/2011/09/using-aspectjs-afterthrowing-advice-in.html#.Vb-6FPkppUw

//    @Before("execution(* SimpleService.checkName())")
//    public void logBeforeV1(JoinPoint joinPoint)
//    {
//        System.out.println("SimpleService.logBeforeV1() : " + joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* SimpleService.checkName())")
//    public void logAfterV1(JoinPoint joinPoint)
//    {
//        System.out.println("SimpleService.logAfterV1() : " + joinPoint.getSignature().getName());
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* SimpleService.checkName())",
//            throwing="ex")
//    public void doRecoveryActions(Throwable ex) {
//
//        System.out.println("Залогируем ошибку: " + ex.getClass());
//        // ...
//    }

//    @Before("@annotation(technicalLogging)")
//    public void makeLog2(TechnicalLogging technicalLogging) throws Throwable {
//        System.out.println("MakeLog2!");
//
//    }

    @AfterThrowing(value = "@annotation(technicalLogging)", throwing = "ex")
    public void doRecoveryActions(TechnicalLogging technicalLogging, Throwable ex) {

        System.out.println("Залогируем ошибку: " + ex.getClass());
        // ...
    }


    @Around("@annotation(technicalLogging)")
    public Object makeLog(ProceedingJoinPoint pjp, TechnicalLogging technicalLogging) throws Throwable {

        System.out.println("Залогируем входящее сообщение!");
        Object[] args = pjp.getArgs();
        Object result = pjp.proceed(args);
        System.out.println("Залогируем ответ сообщение!");

        return result;
    }
}
