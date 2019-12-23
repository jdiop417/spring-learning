package org.learning.springbootcache.service;

import org.learning.springbootcache.bean.Employee;
import org.learning.springbootcache.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Service
public class EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    public Employee getEmpById(Integer id) {
        System.out.println("查询的id为" + id);
        return employeeMapper.getEmpById(id);
    }
}
