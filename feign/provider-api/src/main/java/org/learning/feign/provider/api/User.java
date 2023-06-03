package org.learning.feign.provider.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 9140703049993269471L;

    private Long id;
    private String name;
}
