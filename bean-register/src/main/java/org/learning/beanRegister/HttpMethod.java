package org.learning.beanRegister;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HttpMethod {
    /**
     * 路径
     *
     * @return
     */
    String path();

    /**
     * 请求类型
     *
     * @return
     */
    RequestType requestType();

    enum RequestType {
        GET, POST
    }
}
