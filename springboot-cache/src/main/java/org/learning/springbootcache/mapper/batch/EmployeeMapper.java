package org.learning.springbootcache.mapper.batch;

import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.executor.BatchResult;
import org.learning.springbootcache.entity.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployeeMapper {
    void insertEmployee(Employee employee);

    void deletEmpById(@NotNull @Param("id") Integer id);


    void updateEmp(Employee employee);

    Employee getEmpById(Integer id);

    Employee getEmpByLastName(String lastname);

    Employee getEmpByEmail(String email);

    @Flush
    List<BatchResult> flushStatements();
}
