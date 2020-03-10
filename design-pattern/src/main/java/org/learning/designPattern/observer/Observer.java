package org.learning.designPattern.observer;

import java.util.Observable;

public class Observer implements java.util.Observer {

    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + "收到到了消息：" + ((Subject) o).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
