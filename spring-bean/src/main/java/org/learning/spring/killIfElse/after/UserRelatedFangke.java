package org.learning.spring.killIfElse.after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userRelatedFangke")
@RelatedTypeAnnotation(value = UserRelatedType.FANGKE)
public class UserRelatedFangke implements UserRelated {
    @Override
    public List<String> list() {
        System.out.println("我的访客！");
        return new ArrayList<>();
    }
}
