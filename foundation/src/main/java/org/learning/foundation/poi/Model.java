package org.learning.foundation.poi;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : yang.chen
 * @mail yang.chen@changhong.com
 * @date: 2021-06-11 20:46
 * @description :
 * @since
 */
@Data
public class Model implements Serializable {
    private static final long serialVersionUID = -6590762297276866029L;

    private String name;
    private String formula;
    private String weight;
    private String rt;
    private String id;

}
