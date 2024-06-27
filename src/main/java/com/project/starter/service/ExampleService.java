package com.project.starter.service;

import com.project.starter.dao.ExampleDao;
import com.project.starter.dto.ExampleDto;
import com.project.starter.service.model.ListDataPagination;
import com.project.starter.utils.ExcelRenderer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExampleService {

    private final ExampleDao exampleDao;
    private ExportExcelService exportExcelService;

    @Autowired
    public ExampleService(ExampleDao exampleDao, ExportExcelService exportExcelService) {
        this.exampleDao = exampleDao;
        this.exportExcelService = exportExcelService;
    }
    public ListDataPagination<ExampleDto> getExampleInfo(int page, int size) throws Exception {
        ListDataPagination<ExampleDto> response = new ListDataPagination<>();
        List<ExampleDto> result = new ArrayList<>();
        try {
            result = exampleDao.getExampleInfoQuery(page, size);
            if(!result.isEmpty()) {
                response.setTotal(result.get(0).getTotal());
                response.setList(result);
            }else {
                response.setTotal(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Errors occurred in getExampleInfo");
        }
        return response;
    }

    public Boolean createUser(ExampleDto request) throws Exception {
        Boolean response;
        try {
            response = exampleDao.createUser(request);
        } catch (Exception e) {
            throw new Exception("Data Insertion Fail");
        }
        return response;
    }

    public Boolean editUser(ExampleDto request) throws Exception {
        Boolean response;
        try {
            response = exampleDao.editUser(request);
        } catch (Exception e) {
            throw new Exception("Data Update Fail");
        }
        return response;
    }

    public SXSSFWorkbook getUserReportExcel(List<ExampleDto> dataList, String reportname) {
        Format formatter = new SimpleDateFormat("dd MMMM yyyy hh:mm ");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String docDate = "Document Date : " + formatter.format(new Date());
        final String[] HEADERs = { "No." , "Firstname", "Lastname" , "Gender" , "Age" , "Created - Date"};

        SXSSFWorkbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet(reportname);
        ExcelRenderer renderer = new ExcelRenderer(sheet);

        int columnCount = 0;
        int rowCount = 0;
        sheet.setColumnWidth(columnCount++, 20 * 128);
        sheet.setColumnWidth(columnCount++, 20 * 256);
        sheet.setColumnWidth(columnCount++, 20 * 256);
        sheet.setColumnWidth(columnCount++, 20 * 256);
        sheet.setColumnWidth(columnCount++, 20 * 256);
        sheet.setColumnWidth(columnCount, 20 * 256);

        // Title Row 1
        CellRangeAddress cellRangeAddress = new CellRangeAddress(rowCount, rowCount, 0, HEADERs.length - 1);
        sheet.addMergedRegion(cellRangeAddress);
        Row titleRow1 = sheet.createRow(rowCount++);
        exportExcelService.createCell(titleRow1, 0, "Example User List", renderer.csHeaderBold);

        // Document Date
        cellRangeAddress = new CellRangeAddress(rowCount, rowCount, 0, HEADERs.length - 1);
        sheet.addMergedRegion(cellRangeAddress);
        Row titleRow4 = sheet.createRow(rowCount++);
        exportExcelService.createCell(titleRow4, 0, docDate, renderer.csNormalRight);

        // Column Header
        Row headerRow = sheet.createRow(rowCount++);
        exportExcelService.createCell(headerRow, 0, HEADERs[0], renderer.csHeaderColumn, 500);
        exportExcelService.createCell(headerRow, 1, HEADERs[1], renderer.csHeaderColumn, 500);
        exportExcelService.createCell(headerRow, 2, HEADERs[2], renderer.csHeaderColumn, 500);
        exportExcelService.createCell(headerRow, 3, HEADERs[3], renderer.csHeaderColumn, 500);
        exportExcelService.createCell(headerRow, 4, HEADERs[4], renderer.csHeaderColumn, 500);
        exportExcelService.createCell(headerRow, 5, HEADERs[5], renderer.csHeaderColumn, 500);

        int index = 1;
        for(ExampleDto data : dataList) {
            int columnLoop = 0;
            Row row = sheet.createRow(rowCount++);
            exportExcelService.createCell(row, columnLoop++, index++, renderer.csBodyColumn, 300);
            exportExcelService.createCell(row, columnLoop++, data.getFirstName(), renderer.csBodyColumnRight, 300);
            exportExcelService.createCell(row, columnLoop++, data.getLastName(), renderer.csBodyColumnRight, 300);
            exportExcelService.createCell(row, columnLoop++, data.getLastName(), renderer.csBodyColumn, 300);
            exportExcelService.createCell(row, columnLoop++, data.getLastName(), renderer.csBodyColumnNumber, 300);
            LocalDate localDate = LocalDateTime.parse(data.getCreateDate(), inputFormatter).toLocalDate();
            exportExcelService.createCell(row, columnLoop, localDate.format(outputFormatter), renderer.csBodyColumnRight, 300);
        }

        return workbook;
    }
}
