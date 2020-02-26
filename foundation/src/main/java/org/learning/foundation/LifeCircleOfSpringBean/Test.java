package org.learning.foundation.LifeCircleOfSpringBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        annotationConfigApplicationContext.destroy();
    }

}
