package org.learning.springbootcache.service;

import org.learning.springbootcache.bean.Employee;
import org.learning.springbootcache.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@Service
public class EmployeeService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp", key = "#id", condition = "#id>0")
    public Employee getEmpById(Integer id) {
        logger.debug("查询" + id + "号员工");
        return employeeMapper.getEmpById(id);
    }

    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        logger.debug("更新" + employee.getId() + "号员工");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id", beforeInvocation = true)
    public void deleteEmp(@NotNull Integer id) {
        logger.debug("删除" + id + "号员工");
        employeeMapper.deletEmpById(id);
    }


    @Caching(
            cacheable = {@Cacheable(value = "emp", key = "#lastname")},
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastname) {
        return employeeMapper.getEmpByLastName(lastname);
    }
}
