package org.learning.springbootcache.mapper;

import org.apache.ibatis.annotations.*;
import org.learning.springbootcache.bean.Employee;

import javax.validation.constraints.NotNull;

@Mapper
public interface EmployeeMapper {
    @Insert("insert into Employee(last_name,email,gender,d_id) values(#{lastName},#{email},#{gender},#{did})")
    void insertEmployee(Employee employee);

    @Delete("delete from  Employee where id=#{id}")
    void deletEmpById(@NotNull Integer id);


    @Update("update Employee set last_name=#{lastName},email=#{email},gender=#{gender},d_id=#{did}")
    void updateEmp(Employee employee);

    @Select("select * from Employee where id=#{Employee}")
    Employee getEmpById(Integer Employee);
}
