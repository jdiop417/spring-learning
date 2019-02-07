package org.learing.spring.generics;

import com.google.common.collect.Lists;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class Demo {

    private static <T extends Number> ArrayList<T> parseNumberList(String sourStr, String split, Class<T> targetClass) {
        ArrayList list = Lists.newArrayList();
        String[] strs = sourStr.split(split);
        for (String str : strs) {
            if (StringUtils.isEmpty(str)) continue;
            list.add(NumberUtils.parseNumber(str, targetClass));
        }
        return list;
    }


    public static void main(String[] args) {
        String text = "1,2,2,3,3,3,";
        ArrayList<Long> result = parseNumberList(text, ",", Long.class);
        for (Long tmp : result) {
            System.out.println(tmp);
        }
    }


}
