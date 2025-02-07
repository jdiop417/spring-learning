package org.learning.mybatis.entity;

import jakarta.annotation.Generated;

public class Employee {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.427+08:00", comments="Source field: employee.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.428+08:00", comments="Source field: employee.last_name")
    private String lastName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.gender")
    private Integer gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.d_id")
    private Integer dId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.428+08:00", comments="Source field: employee.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.428+08:00", comments="Source field: employee.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.last_name")
    public String getLastName() {
        return lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.gender")
    public Integer getGender() {
        return gender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.d_id")
    public Integer getdId() {
        return dId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-02-07T21:20:43.429+08:00", comments="Source field: employee.d_id")
    public void setdId(Integer dId) {
        this.dId = dId;
    }
}