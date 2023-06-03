package org.learning.feign.consumer;

import org.learning.feign.provider.api.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(url = "http://localhost:8989", value = "user")
public interface UserClient extends UserService {
}
