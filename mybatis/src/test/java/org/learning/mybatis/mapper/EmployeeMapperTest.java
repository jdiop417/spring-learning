package org.learning.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learning.mybatis.entity.Employee;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.learning.mybatis.mapper.EmployeeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void selectOne() {

        SelectStatementProvider selectStatement = select(BasicColumn.columnList(id)).from(EmployeeDynamicSqlSupport.employee).where(id, isGreaterThan(1)).build().render(RenderingStrategies.MYBATIS3);
        employeeMapper.selectMany(selectStatement);

        SelectStatementProvider selectStatementProvider = select(count(id)).from(EmployeeDynamicSqlSupport.employee).where(id, isGreaterThan(1)).build().render(RenderingStrategies.MYBATIS3);
        long count1 = employeeMapper.count(selectStatementProvider);

        QueryExpressionDSL.FromGatherer<SelectModel> fromGatherer = select(count(id));
        QueryExpressionDSL<SelectModel> start = fromGatherer.from(EmployeeDynamicSqlSupport.employee);
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder whereBuilder = start.where(id, isGreaterThan(1));
        long count2 = employeeMapper.count(whereBuilder
                .build()
                .render(RenderingStrategies.MYBATIS3));


        SelectDSLCompleter selectDSLCompleter = c -> c.where(id, isGreaterThan(1));
        QueryExpressionDSL<SelectModel> fromGatherer1 = select(count(id)).from(employee);
        SelectModel selectModel = selectDSLCompleter.apply(fromGatherer1).build();
        long count3 = employeeMapper.count(selectModel.render(RenderingStrategies.MYBATIS3));


        List<Employee> select1 = employeeMapper.select(selectDSLCompleter);

        QueryExpressionDSL.FromGatherer<SelectModel> fromGatherer2 = select(BasicColumn.columnList(id, lastName, email, gender, dId));
        QueryExpressionDSL<SelectModel> start2 = fromGatherer2.from(EmployeeDynamicSqlSupport.employee);
        start2.orderBy(id.descending()).limit(10).offset(0);
        SelectStatementProvider selectStatementProvider1 = selectDSLCompleter.apply(start2).build().render(RenderingStrategies.MYBATIS3);
        List<Employee> select2 = employeeMapper.selectMany(selectStatementProvider1);

        List<Employee> select3 = employeeMapper.page(id, selectDSLCompleter, 1, 10, id.descending());

        System.out.println();
    }

}