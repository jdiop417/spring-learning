package org.learning.foundation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut("execution(* org.learning.foundation.aop.TestBean.test(..))")
    public void test() {
    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint pjp) {
        System.out.println("before1");
        Object retVal = null;
        try {
            retVal = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return retVal;
    }
}
