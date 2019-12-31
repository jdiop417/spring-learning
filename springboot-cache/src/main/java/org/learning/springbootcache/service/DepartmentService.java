package org.learning.springbootcache.service;

import org.learning.springbootcache.bean.Department;
import org.learning.springbootcache.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "dept")
public class DepartmentService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "#id", condition = "#id>0")
    public Department getDeptById(Integer id) {
        logger.debug("查询" + id + "号员工");
        return departmentMapper.getDeptById(id);
    }

}
