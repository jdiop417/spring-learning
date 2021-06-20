package org.learning;


import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Test {

    private static final Map<String, Integer> elements = new HashMap<>();

    static {
        elements.put("C", 12);
        elements.put("O", 16);
        elements.put("H", 1);
        elements.put("N", 14);
        elements.put("S", 32);
    }


    public static void main(String[] args) {
        String formulaStr = "C24H36O5\n" +
                "C19H28O3 C19H22O2 C19H28O3 C24H38O7 C19H26O3 C24H34O4 C19H26O2 C21H28O4 C24H38O5 C19H30O3 C24H38O5 C19H26O5 C26H42O6 C25H40O6\n" +
                "C20H32O4\n" +
                "C24H36O6 C19H24O3 C19H30O4 C19H30O4 C24H36O4 C19H28O2 C25H42O6\n" +
                "C21H23NO4 C21H22O5 C23H27NO4 C23H26O5 C21H26O5\n" +
                "C23H30O5\n" +
                "C21H24O7 C23H28O7 C20H22O6 C21H24O5\n" +
                "C23H28O5\n" +
                "C20H26O4 C21H28O4 C21H28O4 C21H25NO4 C23H29NO4 C20H27NO3\n" +
                "C22H31NO3\n" +
                "C21H27NO4 C23H31NO4 C23H32O4 " +
                "C23H32O4 C20H30O8S\n" +
                "C21H26O6\n" +
                "C23H32O5 C18H32O2\n" +
                "C18H30O2 C13H14O5 C18H36O2 C16H32O2 C18H36O3 C13H12O4\n" +
                "C10H17NO4 C10H17NO4 C28H44O\n" +
                "C29H48O C29H50O C29H48O2 C29H46O2 C29H48O2 C29H46O2 C35H60O6 C44H76O2 C15H22O2\n" +
                "C15H22O2 C15H22O2 C15H20O2 C15H20O2 C15H20O2 C15H24O2 C15H10O4\n" +
                "C15H10O5 C22H28O8 C20H24O6 C10H8O4 C30H48O3 C32H50O4 C30H50O C15H26O C20H34O\n" +
                "C19H30O6 C29H50O4 C15H24O C15H12O4 C10H18N2O3 C19H21NO5 C13H14O5 C6H5NO3\n" +
                "C32H66";
        String[] split = formulaStr.split("\n");
        Map<String, Integer> formulas = Arrays.stream(split)
                .flatMap(s -> Arrays.stream(s.split(" ")).filter(t -> !StringUtils.isEmpty(t)))
                .sorted()
                .collect(Collectors.toMap(Function.identity(), Test::molecularMass, (u1, u2) -> u1, LinkedHashMap::new));
        formulas.forEach((k, v) -> System.out.println(String.format("%-12s %s", k, v)));
    }


    private static int molecularMass(String formula) {
        if (StringUtils.isEmpty(formula) || StringUtils.isEmpty(formula = formula.trim())) {
            return 0;
        }

        int mass = 0;
        String c = null;
        int n = 0;
        for (int i = 0; i < formula.length(); i++) {
            String t = formula.substring(i, i + 1);
            if (elements.containsKey(t)) {
                mass += elements.getOrDefault(c, 0) * n;
                c = t;
                n = i == formula.length() - 1 ? 1 : 0;
                continue;
            }
            n = n * 10 + NumberUtils.parseNumber(t, Integer.class);
        }
        mass += elements.getOrDefault(c, 0) * n;
        return mass;
    }

}
