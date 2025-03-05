package org.learning.mybatis.mapper;

import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.learning.mybatis.entity.Employee;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.learning.mybatis.mapper.EmployeeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface EmployeeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Employee>, CommonUpdateMapper {
    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.435+08:00", comments = "Source Table: employee")
    BasicColumn[] selectList = BasicColumn.columnList(id, lastName, email, gender, dId);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.431+08:00", comments = "Source Table: employee")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "EmployeeResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "last_name", property = "lastName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.INTEGER),
            @Result(column = "d_id", property = "dId", jdbcType = JdbcType.INTEGER)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.432+08:00", comments = "Source Table: employee")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("EmployeeResult")
    Optional<Employee> selectOne(SelectStatementProvider selectStatement);

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.432+08:00", comments = "Source Table: employee")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employee, completer);
    }

    default long count(BasicColumn column, CountDSLCompleter completer) {
        return MyBatis3Utils.count(this::count, column, employee, completer);
    }

    default List<Employee> page(BasicColumn countColumn, SelectDSLCompleter completer, long pageNo, long pageSize, SortSpecification... order) {
        // count
        QueryExpressionDSL<SelectModel> fromGatherer = SqlBuilder.select(SqlBuilder.count(countColumn)).from(employee);
        SelectModel selectModel = completer.apply(fromGatherer).build();
        long count = count(selectModel.render(RenderingStrategies.MYBATIS3));
        if (count <= 0) {
            return new ArrayList<>();
        }

        // limit
        QueryExpressionDSL.FromGatherer<SelectModel> fromGatherer2 = SqlBuilder.select(selectList);
        QueryExpressionDSL<SelectModel> start = fromGatherer2.from(EmployeeDynamicSqlSupport.employee);
        start.orderBy(order).limit(pageSize).offset((pageNo - 1) * pageSize);
        return selectMany(MyBatis3Utils.select(start, completer));
    }


    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.433+08:00", comments = "Source Table: employee")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employee, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.433+08:00", comments = "Source Table: employee")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.433+08:00", comments = "Source Table: employee")
    default int insert(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
                c.map(id).toProperty("id")
                        .map(lastName).toProperty("lastName")
                        .map(email).toProperty("email")
                        .map(gender).toProperty("gender")
                        .map(dId).toProperty("dId")
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.434+08:00", comments = "Source Table: employee")
    default int insertMultiple(Collection<Employee> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, employee, c ->
                c.map(id).toProperty("id")
                        .map(lastName).toProperty("lastName")
                        .map(email).toProperty("email")
                        .map(gender).toProperty("gender")
                        .map(dId).toProperty("dId")
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.434+08:00", comments = "Source Table: employee")
    default int insertSelective(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
                c.map(id).toPropertyWhenPresent("id", row::getId)
                        .map(lastName).toPropertyWhenPresent("lastName", row::getLastName)
                        .map(email).toPropertyWhenPresent("email", row::getEmail)
                        .map(gender).toPropertyWhenPresent("gender", row::getGender)
                        .map(dId).toPropertyWhenPresent("dId", row::getdId)
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.435+08:00", comments = "Source Table: employee")
    default Optional<Employee> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, employee, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.436+08:00", comments = "Source Table: employee")
    default List<Employee> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, employee, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.436+08:00", comments = "Source Table: employee")
    default List<Employee> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, employee, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.436+08:00", comments = "Source Table: employee")
    default Optional<Employee> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.436+08:00", comments = "Source Table: employee")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, employee, completer);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.436+08:00", comments = "Source Table: employee")
    static UpdateDSL<UpdateModel> updateAllColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(lastName).equalTo(row::getLastName)
                .set(email).equalTo(row::getEmail)
                .set(gender).equalTo(row::getGender)
                .set(dId).equalTo(row::getdId);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.437+08:00", comments = "Source Table: employee")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(lastName).equalToWhenPresent(row::getLastName)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(gender).equalToWhenPresent(row::getGender)
                .set(dId).equalToWhenPresent(row::getdId);
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.437+08:00", comments = "Source Table: employee")
    default int updateByPrimaryKey(Employee row) {
        return update(c ->
                c.set(lastName).equalTo(row::getLastName)
                        .set(email).equalTo(row::getEmail)
                        .set(gender).equalTo(row::getGender)
                        .set(dId).equalTo(row::getdId)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2025-02-07T21:20:43.437+08:00", comments = "Source Table: employee")
    default int updateByPrimaryKeySelective(Employee row) {
        return update(c ->
                c.set(lastName).equalToWhenPresent(row::getLastName)
                        .set(email).equalToWhenPresent(row::getEmail)
                        .set(gender).equalToWhenPresent(row::getGender)
                        .set(dId).equalToWhenPresent(row::getdId)
                        .where(id, isEqualTo(row::getId))
        );
    }
}