package org.learning.spring.killIfElse.after;

public enum UserRelatedType {
    SHUOSHUO("说说"),
    RIZHI("日志"),
    ZHAOPIAN("照片"),
    FANGKE("访客");

    private String desc;

    UserRelatedType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
