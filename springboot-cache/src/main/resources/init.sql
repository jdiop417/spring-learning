drop database if exists spring_cache;
create database spring_cache;
use spring_cache;

drop table if exists employee;
create table employee
(
    id        int auto_increment
        primary key,
    last_name varchar(20) null,
    email     varchar(30) null,
    gender    int         not null comment '1:男，0：女',
    d_id      int         not null comment '部门id'
);



drop table if exists department;
create table department
(
    id              int auto_increment
        primary key,
    department_name varchar(100) not null
);


INSERT INTO spring_cache.employee (id, last_name, email, gender, d_id)
VALUES (1, '李四', 'lishi@gmail.com', 0, 1);
INSERT INTO spring_cache.employee (id, last_name, email, gender, d_id)
VALUES (3, 'lisi', 'lishi@gmail.com', 0, 1);
INSERT INTO spring_cache.employee (id, last_name, email, gender, d_id)
VALUES (4, 'lisi0', 'lishi@gmail.com', 0, 2);
INSERT INTO spring_cache.employee (id, last_name, email, gender, d_id)
VALUES (5, 'lishi1', 'lishi@gmail.com', 0, 1);
INSERT INTO spring_cache.employee (id, last_name, email, gender, d_id)
VALUES (6, 'lishi2', 'lishi@gmail.com', 0, 1);


INSERT INTO spring_cache.department (id, department_name)
VALUES (1, '开发部');