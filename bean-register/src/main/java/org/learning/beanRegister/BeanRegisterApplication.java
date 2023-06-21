package org.learning.beanRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(SspaiRegister.class)
@SpringBootApplication
public class BeanRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanRegisterApplication.class, args);
    }

}
