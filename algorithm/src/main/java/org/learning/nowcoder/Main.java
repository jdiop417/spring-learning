package org.learning.nowcoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> params = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //oj读取多行
        //以空白行结束输入
        while (true) {
            String param = scanner.nextLine();
            if (param == null || param.trim().length() == 0) {
                break;
            }
            params.add(param);
        }
        System.out.println(test(params));

//        //知道行数
//        int i = 0;
//        while (i++ < 5) {
//            String param = scanner.nextLine();
//            params.add(param);
//        }
//        System.out.println(test(params));

//        while (scanner.hasNextLine()) {
//            params.add(scanner.nextLine());
//        }
//        System.out.println(test(params));

    }

    public static int test(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return 0;
        }

        Map<String, List<String>> collect = strs.stream()
                .map(s -> s.trim())
                .filter(s -> s != null && s.length() > 0)
                .collect(Collectors.groupingBy(s -> s.substring(0, 10)));

        int count = 0;
        for (Map.Entry<String, List<String>> date : collect.entrySet()) {

            List<String> times = date.getValue();
            times.sort((o1, o2) -> o1.compareTo(o2));
            String mintime = times.get(0);
            for (String time : times) {
                if (time == mintime) {
                    count++;
                } else {
                    break;
                }
            }

        }
        return count;
    }
}
