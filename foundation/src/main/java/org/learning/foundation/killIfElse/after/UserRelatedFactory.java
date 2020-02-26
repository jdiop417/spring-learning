package org.learning.foundation.killIfElse.after;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserRelatedFactory {
    private static Map<UserRelatedType, UserRelated> userRelatedMap = Maps.newConcurrentMap();
    @Autowired
    private SpringContextUtil springContextUtil;

    //工厂将 Spring 装配的相关的 Bean 用 Map 保存起来
    public UserRelatedFactory() {
        Map<String, Object> beanMap = springContextUtil.getContext().getBeansWithAnnotation(RelatedTypeAnnotation.class);

        for (Object userRelated : beanMap.values()) {
            RelatedTypeAnnotation annotation = userRelated.getClass().getAnnotation(RelatedTypeAnnotation.class);
            userRelatedMap.put(annotation.value(), (UserRelated) userRelated);
        }
    }

    public static UserRelated createRelated(UserRelatedType relatedType) {
        return userRelatedMap.get(relatedType);
    }

}
