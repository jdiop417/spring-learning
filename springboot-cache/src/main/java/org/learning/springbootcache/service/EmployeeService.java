package org.learning.springbootcache.service;

import org.learning.springbootcache.bean.Employee;
import org.learning.springbootcache.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employeeMapper.getEmpById(id);
    }
}
