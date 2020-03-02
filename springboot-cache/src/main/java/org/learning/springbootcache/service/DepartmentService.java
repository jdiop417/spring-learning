package org.learning.springbootcache.service;

import lombok.extern.slf4j.Slf4j;
import org.learning.springbootcache.entity.Department;
import org.learning.springbootcache.mapper.DepartmentMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
@CacheConfig(cacheNames = "dept")
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "#id", condition = "#id>0")
    public Department getDeptById(Integer id) {
        log.debug("查询" + id + "号员工");
        return departmentMapper.getDeptById(id);
    }

}
