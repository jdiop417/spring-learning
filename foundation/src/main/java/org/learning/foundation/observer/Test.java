package org.learning.foundation.observer;

public class Test {
    public static void main(String[] args) {
        Observer gf = new Observer("girlFriend");
        Observer mom = new Observer("mom");
        Subject subject = new Subject("这是条消息");
        subject.addObserver(gf);
        subject.addObserver(mom);
        subject.setContent("this is msg");

    }
}
