package org.learing.spring.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut(value = "execution(* org.learing.spring.annotations.Person.set*(..))")
    public void test() {
    }

    @Before(value = "test()")
    public void before() {

    }

    @After("test()")
    public void after() {

    }

    @Around(value = "test()")
    public Object around(ProceedingJoinPoint pjp) {

        System.out.println("befor setter");
        Signature signature = pjp.getSignature();
        try {
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = methodSignature.getMethod();
                System.out.println(method.getName());
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                    Object[] args = pjp.getArgs();
                    args[0] = myAnnotation.value();
                    System.out.println(args[0]);
                }
            }
            System.out.println("after setter");
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
