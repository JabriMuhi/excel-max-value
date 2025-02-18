package org.jabrimuhi.excelmaxvalue.tools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXLSX {
    public static List<Integer> loadDataFromExcel(String filePath) throws IOException {
        List<Integer> values = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet valuesSheet = workbook.getSheetAt(0);
            if (valuesSheet == null) {
                throw new IllegalArgumentException("Sheet is missing or empty");
            }

            for (Row row : valuesSheet) {
                values.add((int)row.getCell(0).getNumericCellValue());
            }
        }
        return values;
    }
}
