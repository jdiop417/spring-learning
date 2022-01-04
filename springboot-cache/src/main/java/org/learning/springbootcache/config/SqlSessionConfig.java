package org.learning.springbootcache.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqlSessionConfig {

    @Bean(name = "defaultSqlSessionTemplate")
    public SqlSessionTemplate defaultSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public SqlSessionTemplate reuseSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.REUSE);
    }

    @Bean
    public SqlSessionTemplate batchSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }
    @MapperScan(basePackages = "org.learning.springbootcache.mapper.defaul", sqlSessionTemplateRef = "defaultSqlSessionTemplate")
    class DefaultMapperScan {
    }

    @MapperScan(basePackages = "org.learning.springbootcache.mapper.reuse", sqlSessionTemplateRef = "reuseSqlSessionTemplate")
    class ReuseMapperScan {
    }

    @MapperScan(basePackages = "org.learning.springbootcache.mapper.batch", sqlSessionTemplateRef = "batchSqlSessionTemplate")
    class BatchMapperScan {
    }
}


