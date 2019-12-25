package org.learning.springbootcache.controller;

import org.learning.springbootcache.bean.Employee;
import org.learning.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    @Cacheable(cacheNames = "emp", keyGenerator = "mykeyGenerator", condition = "#id>0")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }
}
