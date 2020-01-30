package org.learning.spring.customannotation;

import java.lang.reflect.Field;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Person person = new Person();

        Class<?> c = person.getClass();
        boolean typeAnnotationExit = c.isAnnotationPresent(MyAnnotation.class);
        if (typeAnnotationExit) {
            MyAnnotation myAnnotation = c.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.value());
        }


        Field name = c.getDeclaredField("name");
        boolean filedAnnotationExit = name.isAnnotationPresent(MyAnnotation.class);
        if (filedAnnotationExit) {
            MyAnnotation myAnnotation = name.getAnnotation(MyAnnotation.class);
            name.setAccessible(Boolean.TRUE);
            name.set(person, myAnnotation.value());
            System.out.println(person.getName());
        }
    }


}
