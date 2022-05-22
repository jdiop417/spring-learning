package org.learning.springbootcache.mapper.defaul;


import org.learning.springbootcache.entity.Department;

public interface DepartmentMapper {

    Department getDeptById(Integer id);

    int add(Department department);
}
