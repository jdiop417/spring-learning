package org.learning.springbootcache.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //1:男，0：女
    private Integer did;

}
