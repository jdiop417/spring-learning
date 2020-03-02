package org.learning.springbootcache.mapper;

import org.apache.ibatis.annotations.Param;
import org.learning.springbootcache.entity.Employee;

import javax.validation.constraints.NotNull;

public interface EmployeeMapper {
    void insertEmployee(Employee employee);

    void deletEmpById(@NotNull @Param("id") Integer id);


    void updateEmp(Employee employee);

    Employee getEmpById(Integer id);

    Employee getEmpByLastName(String lastname);

    Employee getEmpByEmail(String email);
}
