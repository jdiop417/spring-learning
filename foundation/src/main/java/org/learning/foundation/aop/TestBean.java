package org.learning.foundation.aop;

public class TestBean {
    private String testStr = "testStr";

    public TestBean() {
    }

    public TestBean(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("This is test");
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }


}
