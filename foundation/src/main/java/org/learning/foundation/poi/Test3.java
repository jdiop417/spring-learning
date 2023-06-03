package org.learning.foundation.poi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : yang.chen
 * @mail yang.chen@changhong.com
 * @date: 2021-09-04 15:29
 * @description :
 * @since
 */

public class Test3 {
    public static void main(String[] args) throws Exception {

        // step 1 :refer
        Workbook referWb = WorkbookFactory.create(new FileInputStream("/Users/yangchen/Desktop/excel/chenjia5444.mzvault(1).xlsx"));
        Workbook referWb2 = WorkbookFactory.create(new FileInputStream("/Users/yangchen/Desktop/excel/chenjia3756.mzcloud(1).xlsx"));

        List<Mzc> refererDatas = getRefererData(referWb);
        refererDatas.addAll(getRefererData(referWb2));


        // step 2: target
        Workbook targetWb = WorkbookFactory.create(new FileInputStream("/Users/yangchen/Desktop/excel/313(1)(1).xlsx"));
        List<Mzc> targetDatas = getTargetData(targetWb);


        // step 3: filter
        targetDatas = targetDatas.stream().map(t -> {
            int i = refererDatas.indexOf(t);
            if (i == -1) {
                return null;
            }
            Mzc mzc = refererDatas.get(i);
            mzc.setM1(t.getM1());
            return mzc;
        }).filter(Objects::nonNull).collect(Collectors.toList());


        // step 4 :export
        if (CollectionUtils.isEmpty(targetDatas)) {
            return;
        }

        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("0");
        Row head = sheet.createRow(0);
        setCellValue(head, 0, "Name");
        setCellValue(head, 1, "Formula");
        setCellValue(head, 2, "Molecular Weight");
        setCellValue(head, 3, "RT [min]");
        setCellValue(head, 4, "M1.VIPpred");
        for (int i = 0; i < targetDatas.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Mzc mzc = targetDatas.get(i);
            setCellValue(row, 0, mzc.getName());
            setCellValue(row, 1, mzc.getFormula());
            setCellValue(row, 2, mzc.getMoleculaWeight());
            setCellValue(row, 3, mzc.getRt());
            setCellValue(row, 4, mzc.getM1());
        }
        workbook.write(new FileOutputStream("/Users/yangchen/Desktop/excel/t.xlsx"));
    }

    private static List<Mzc> getTargetData(Workbook targetWb) {
        List<Mzc> retVal = Lists.newArrayList();
        Sheet sheet = targetWb.getSheetAt(0);

        for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            Mzc mzc = new Mzc.MzcBuilder().idepedent(getCellStringVal(row, 0))
                    .m1(getCellStringVal(row, 1)).build();
            if (Double.compare(Double.parseDouble(mzc.getM1()), Double.parseDouble("1.50")) >= 0) {
                retVal.add(mzc);
            }
        }
        return retVal;
    }

    private static List<Mzc> getRefererData(Workbook referWb) {
        List<Mzc> refers = Lists.newArrayList();
        Sheet sheet = referWb.getSheetAt(0);
        for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            Mzc mzc = new Mzc.MzcBuilder().name(getCellStringVal(row, 1))
                    .formula(getCellStringVal(row, 2))
                    .moleculaWeight(getCellStringVal(row, 9))
                    .rt(getCellStringVal(row, 10))
                    .build();
            mzc.setIdepedent(mzc.getFormula() + mzc.getMoleculaWeight() + mzc.getRt());
            refers.add(mzc);
        }
        return refers;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Mzc {
        private String name;
        private String formula;
        private String moleculaWeight;
        private String rt;
        private String idepedent;
        private String m1;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Mzc mzc = (Mzc) o;
            return Objects.equals(idepedent, mzc.idepedent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idepedent);
        }
    }


    public static Cell setCellValue(@NotNull Row row, int index, String value) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            cell = row.createCell(index);
        }
        cell.setCellValue(StringUtils.isEmpty(value) ? "" : value);
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

}
