package org.learing.spring.aop.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);

    }

}
