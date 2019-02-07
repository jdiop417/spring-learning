package org.learing.spring.generics;

import com.google.common.collect.Lists;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class Demo {

    /**
     * 把字符串变成数字集合
     *
     * @param sourStr     字符串
     * @param split       字符串分隔符
     * @param targetClass 数字类型，eg：integr，Long
     * @return 数字集合
     */
    private static <T extends Number> ArrayList<T> parseNumberList(String sourStr, String split, Class<T> targetClass) {
        if (StringUtils.isEmpty(sourStr)) return new ArrayList<>();

        String[] strs = sourStr.split(split);
        ArrayList list = Lists.newArrayListWithCapacity(strs.length);
        for (String str : strs) {
            if (StringUtils.isEmpty(str)) continue;
            list.add(NumberUtils.parseNumber(str, targetClass));
        }
        return list;
    }


    public static void main(String[] args) {
        String text = null;
        ArrayList<Long> result = parseNumberList(text, ",", Long.class);
        for (Long tmp : result) {
            System.out.println(tmp);
        }
    }


}
