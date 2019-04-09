package org.learing.spring.killIfElse.after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userRelatedShuoshuo")
@RelatedTypeAnnotation(value = UserRelatedType.SHUOSHUO)
public class UserRelatedShuoshuo implements UserRelated {

    @Override
    public List<String> list() {
        System.out.println("我的说说！");
        return new ArrayList<>();
    }
}
