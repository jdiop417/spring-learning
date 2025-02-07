package org.learning.mybatis.mapper;


import org.learning.mybatis.entity.Department;

public interface DepartmentMapper {

    Department getDeptById(Integer id);

    int add(Department department);
}
