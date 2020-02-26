package org.learning.foundation.aliasfor;

import org.springframework.core.annotation.AnnotationUtils;

@MyAnnotation(value = "aa", alias = "aa")
public class Test {
    @org.junit.Test
    public void testForALias() {
        MyAnnotation myAnnotation = getClass().getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.alias());
        System.out.println(myAnnotation.value());
    }

    @org.junit.Test
    public void testForALias2() {
        MyAnnotation myAnnotation = AnnotationUtils.findAnnotation(getClass(), MyAnnotation.class);
        System.out.println(myAnnotation.alias());
        System.out.println(myAnnotation.value());
    }
}
