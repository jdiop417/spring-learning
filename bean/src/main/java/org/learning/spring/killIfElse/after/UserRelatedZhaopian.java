package org.learning.spring.killIfElse.after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userRelatedZhaopian")
@RelatedTypeAnnotation(value = UserRelatedType.ZHAOPIAN)
public class UserRelatedZhaopian implements UserRelated {
    @Override
    public List<String> list() {
        System.out.println("我的照片！");
        return new ArrayList<>();
    }
}
