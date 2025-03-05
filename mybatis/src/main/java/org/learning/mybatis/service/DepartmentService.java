package org.learning.mybatis.service;

import lombok.extern.slf4j.Slf4j;
import org.learning.mybatis.entity.Department;
import org.learning.mybatis.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public Department getDeptById(Integer id) {
        log.debug("查询" + id + "号员工");
        return departmentMapper.getDeptById(id);
    }

}
