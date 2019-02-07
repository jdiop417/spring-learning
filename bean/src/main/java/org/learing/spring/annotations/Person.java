package org.learing.spring.annotations;


@MyAnnotation(value = "Type annotation")
public class Person {
    @MyAnnotation("xiaoming")
    private String name;

    @MyAnnotation("18")
    private Integer age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    @MyAnnotation(value = "xiaoming")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
