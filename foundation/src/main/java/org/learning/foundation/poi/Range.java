package org.learning.foundation.poi;

import lombok.Data;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author : yang.chen
 * @mail yang.chen@changhong.com
 * @date: 2021-06-14 15:37
 * @description :
 * @since
 */
@Data
public class Range implements Serializable {

    private static final long serialVersionUID = 3236972520210216321L;

    private int strart;
    private int end;
    private int num;

    public Range(int strart, int end) {
        this.strart = strart;
        this.end = end;
        this.num = 0;
    }

    public boolean in(String f) {
        if (StringUtils.isEmpty(f)) {
            return false;
        }
        Float number = NumberUtils.parseNumber(f, Float.class);
        if (number >= strart && number < end) {
            return true;
        }
        return false;
    }

}
