package org.learning.springbootcache;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.learning.springbootcache.entity.Employee;
import org.learning.springbootcache.mapper.batch.EmployeeMapper;
import org.learning.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootCacheApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private EmployeeMapper employeeMapper;

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
    @Transactional
    public void test03() {

        for (int i = 7; i < 10; i++) {
            Employee employee = new Employee(i, "user" + i, "user" + i + "@test.com", i % 2, 1);
            employeeMapper.insertEmployee(employee);
        }
        System.out.println("开始批量操作");
        List<BatchResult> batchResults = employeeMapper.flushStatements();
        batchResults.forEach(rs -> {
            System.out.println(rs.getSql());
            System.out.println(rs.getParameterObjects());
            System.out.println(Arrays.toString(rs.getUpdateCounts()));
        });
        System.out.println("结束批量操作");


        System.out.println();
    }

}
