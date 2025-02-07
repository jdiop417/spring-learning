package org.learning.mybatis.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class EmployeeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.43+08:00", comments="Source Table: employee")
    public static final Employee employee = new Employee();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.431+08:00", comments="Source field: employee.id")
    public static final SqlColumn<Integer> id = employee.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.431+08:00", comments="Source field: employee.last_name")
    public static final SqlColumn<String> lastName = employee.lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.431+08:00", comments="Source field: employee.email")
    public static final SqlColumn<String> email = employee.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.431+08:00", comments="Source field: employee.gender")
    public static final SqlColumn<Integer> gender = employee.gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.431+08:00", comments="Source field: employee.d_id")
    public static final SqlColumn<Integer> dId = employee.dId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.43+08:00", comments="Source Table: employee")
    public static final class Employee extends AliasableSqlTable<Employee> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> lastName = column("last_name", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<Integer> dId = column("d_id", JDBCType.INTEGER);

        public Employee() {
            super("employee", Employee::new);
        }
    }
}