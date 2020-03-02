package org.learning.springbootcache.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("Employee")
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //1:男，0：女
    private Integer did;

}
