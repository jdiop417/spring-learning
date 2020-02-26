package org.learning.foundation.clone;

import lombok.Data;

@Data
public class Info implements Cloneable {
    private Long id;
    private Long structCId;
    private String value;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
