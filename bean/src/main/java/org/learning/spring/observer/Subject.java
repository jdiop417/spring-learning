package org.learning.spring.observer;

import java.util.Observable;

public class Subject extends Observable {
    private String content;

    public Subject(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers();
    }
}
