package org.learning.feign.provider;

import org.learning.feign.provider.api.User;
import org.learning.feign.provider.api.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

    public User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("张三");
        return user;
    }
}
