package org.learning.spring.killIfElse.after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userRelatedRizhi")
@RelatedTypeAnnotation(value = UserRelatedType.RIZHI)
public class UserRelatedRizhi implements UserRelated {
    @Override
    public List<String> list() {
        System.out.println("我的日志！");
        return new ArrayList<>();

    }
}
