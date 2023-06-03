package org.learning.feign.consumer;

import org.junit.jupiter.api.Test;
import org.learning.feign.provider.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserClientTest {
    @Autowired
    private UserClient userClient;

    @Test
    public void test() {
        User user = userClient.getUser(1L);
        System.out.println(user);
    }
}
