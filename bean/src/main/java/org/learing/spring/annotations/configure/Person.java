package org.learing.spring.annotations.configure;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("person....constronct");
    }

    public Person() {
        System.out.println("person....constronct");
    }

    public void init() {
        System.out.println("person ....init");
    }

    public void destroy() {
        System.out.println("person....destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("person....setName");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("person....setAge");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
