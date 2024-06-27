package com.project.starter.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ExportExcelService {

    public void generateReport(HttpServletResponse response, String fileName, Workbook workBook) {

        try (workBook; ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".xlsx;");
            response.setContentType("application/octet-stream");
            ServletOutputStream outputStream = response.getOutputStream();
            workBook.write(outputStream);
            workBook.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {

        Cell cell = row.createCell(columnCount);
        if(valueOfCell != null){
            if (valueOfCell instanceof Integer) {
                cell.setCellValue((Integer) valueOfCell);
            } else if (valueOfCell instanceof Long) {
                cell.setCellValue((Long) valueOfCell);
            } else if (valueOfCell instanceof String) {
                cell.setCellValue((String) valueOfCell);
            } else if (valueOfCell instanceof Double) {
                cell.setCellValue((Double) valueOfCell);
            } else {
                cell.setCellValue((Boolean) valueOfCell);
            }
        }else{
            cell.setBlank();
        }

        cell.setCellStyle(style);
    }

    public void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style, Integer... heightCustom) {
        row.setHeight((short) (heightCustom.length > 0 ? heightCustom[0] : 450));
        Cell cell = row.createCell(columnCount);
        if (valueOfCell != null) {
            if (valueOfCell instanceof Integer) {
                cell.setCellValue((Integer) valueOfCell);
            } else if (valueOfCell instanceof Long) {
                cell.setCellValue((Long) valueOfCell);
            } else if (valueOfCell instanceof String) {
                cell.setCellValue((String) valueOfCell);
            } else if (valueOfCell instanceof Double) {
                cell.setCellValue((Double) valueOfCell);
            } else {
                cell.setCellValue((Boolean) valueOfCell);
            }
        } else {
            cell.setBlank();
        }
        cell.setCellStyle(style);
    }
}
