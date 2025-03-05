package org.learning.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.learning.mybatis.mapper.EmployeeDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void selectOne() {
/*        Function<CountDSL<SelectModel>, Buildable<SelectModel>> cc =c -> {
            CountDSL<SelectModel>.CountWhereBuilder where1 = c.where(id, isGreaterThan(1));
            return where1;
        };

        CountDSLCompleter countDSLCompleter = c -> c.where(id, isGreaterThan(1));
        long count = employeeMapper.count(id, countDSLCompleter);

        Function<QueryExpressionDSL<SelectModel>, Buildable<SelectModel>> sc =c-> c.where(id, isGreaterThan(1));
        SelectDSLCompleter sc2 = c -> {
            QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder where1 = c.where(id, isGreaterThan(1));
            return where1.limit(1).offset(0);
        };
        List<Employee> select = employeeMapper.select(sc2);*/





        SelectStatementProvider selectStatement = select(BasicColumn.columnList(id)).from(EmployeeDynamicSqlSupport.employee).where(id, isGreaterThan(1)).build().render(RenderingStrategies.MYBATIS3);
        employeeMapper.selectMany(selectStatement);

        SelectStatementProvider selectStatementProvider = select(count(id)).from(EmployeeDynamicSqlSupport.employee).where(id, isGreaterThan(1)).build().render(RenderingStrategies.MYBATIS3);
        long count1 = employeeMapper.count(selectStatementProvider);

        QueryExpressionDSL.FromGatherer<SelectModel> fromGatherer = select(count(id));
        QueryExpressionDSL<SelectModel> start = fromGatherer.from(EmployeeDynamicSqlSupport.employee);
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder whereBuilder = start.where(id, isGreaterThan(1));
        long count2 = employeeMapper.count(whereBuilder.build().render(RenderingStrategies.MYBATIS3));


        SelectDSLCompleter selectDSLCompleter= c -> c.where(id, isGreaterThan(1));

        fromGatherer=select((id));

        System.out.println();
    }
}