package org.learning.foundation.poi;

import com.google.common.collect.Lists;
import com.sun.istack.internal.NotNull;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yang.chen
 * @mail yang.chen@changhong.com
 * @date: 2021-06-11 19:57
 * @description :
 * @since
 */

public class Test2 {

    private static List<Range> ranges = Lists.newArrayList();

    static {
        ranges.add(new Range(0, 5));
        ranges.add(new Range(5, 10));
        ranges.add(new Range(10, 15));
        ranges.add(new Range(15, 20));
        ranges.add(new Range(20, 25));
        ranges.add(new Range(25, 30));
        ranges.add(new Range(30, 35));
        ranges.add(new Range(30, 35));
        ranges.add(new Range(35, 40));
        ranges.add(new Range(40, 45));
    }

    public static void main(String[] args) throws Exception {
        try (Workbook referWorkbook = WorkbookFactory.create(new FileInputStream("/Users/yangchen/Downloads/chenjia2.xlsx"));
             Workbook workbook = WorkbookFactory.create(new File("/Users/yangchen/Downloads/GeneralList.xlsx"))) {

            // refer
            Sheet referSheet = referWorkbook.getSheetAt(0);
            List<Model> models = new ArrayList<>();
            for (int i = 1; i < referSheet.getLastRowNum(); i++) {
                Row row = referSheet.getRow(i);
                Model model = new Model();
                model.setName(getCellStringVal(row, 0));
                model.setFormula(getCellStringVal(row, 1));
                model.setWeight(getCellStringVal(row, 2));
                model.setRt(getCellStringVal(row, 3));
                model.setId(getCellStringVal(row, 4));
                models.add(model);
            }

            // work
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row.getCell(1).getNumericCellValue() <= 2) {
                    continue;
                }

                for (Model t : models) {
                    if (!StringUtils.equals(t.getId(), getCellStringVal(row, 0))) {
                        continue;
                    }
                    getOrCreateCell(row, 2).setCellValue(t.getName());
                    getOrCreateCell(row, 3).setCellValue(t.getFormula());
                    getOrCreateCell(row, 4).setCellValue(t.getWeight());
                    getOrCreateCell(row, 5).setCellValue(t.getRt());
                    addRanger(t.getRt());
                }

            }

            workbook.write(new FileOutputStream("/Users/yangchen/Downloads/t.xlsx"));
        }
        List<Range> top3 = ranges.stream().sorted(Comparator.comparingInt(Range::getNum).reversed()).limit(3).collect(Collectors.toList());
        System.out.println(top3);


        System.out.println("done");
    }

    public static Cell getOrCreateCell(@NotNull Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            cell = row.createCell(index);
        }
        return cell;
    }

    public static String getCellStringVal(Row row, int index) {
        if (row == null) {
            return "";
        }

        Cell cell = row.getCell(index);
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case FORMULA:
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()).trim();
        }
        return "";
    }


    public static void addRanger(String time) {
        for (Range range : ranges) {
            if (range.in(time)) {
                range.setNum(range.getNum() + 1);
                break;
            }
        }
    }

}
