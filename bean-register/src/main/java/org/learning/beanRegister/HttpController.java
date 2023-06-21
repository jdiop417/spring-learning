package org.learning.beanRegister;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HttpController {
    /**
     * url
     * @return
     */
    String url();

    /**
     * 描述
     * @return
     */
    String desc();
}
