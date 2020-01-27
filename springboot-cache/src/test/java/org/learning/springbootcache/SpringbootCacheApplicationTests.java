package org.learning.springbootcache;

import org.junit.jupiter.api.Test;
import org.learning.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test01() {
//        stringRedisTemplate.opsForValue().append("msg", "hello");
//        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }


    @Test
    public void test02() {
//        Employee emp = employeeService.getEmpById(1);
//        redisTemplate.opsForValue().set("emp-01", emp);
//        System.out.println(redisTemplate.opsForValue().get("emp-01"));
    }

    @Test
    void contextLoads() {

    }

}
