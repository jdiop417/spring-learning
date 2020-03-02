package org.learning.springbootcache.mapper;

import org.junit.jupiter.api.Test;
import org.learning.springbootcache.entity.Employee;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class EmployeeMapperTest {
    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    void insertEmployee() {
        Employee empById = employeeMapper.getEmpById(1);
        empById.setDid(2);
        employeeMapper.insertEmployee(empById);
    }

    @Test
    void deletEmpById() {
        employeeMapper.deletEmpById(2);
    }

    @Test
    void updateEmp() {
        Employee empById = employeeMapper.getEmpById(1);
        empById.setLastName("lisi");
        empById.setDid(1);
        employeeMapper.updateEmp(empById);
    }

    @Test
    void getEmpById() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }
}