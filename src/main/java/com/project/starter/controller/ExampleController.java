package com.project.starter.controller;

import com.project.starter.dto.ExampleDto;
import com.project.starter.model.ResponseGeneral;
import com.project.starter.service.ExampleService;
import com.project.starter.service.ExportExcelService;
import com.project.starter.service.model.ListDataPagination;
import com.project.starter.utils.constant.AppConstant;
import com.project.starter.utils.constant.HttpConstant;
import com.project.starter.utils.enums.ExportType;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/project/example")
public class ExampleController {

    private final ExampleService exampleService;
    private final ExportExcelService exportExcelService;

    @Autowired
    public ExampleController(ExampleService exampleService, ExportExcelService exportExcelService) {
        this.exampleService = exampleService;
        this.exportExcelService = exportExcelService;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<ResponseGeneral<ListDataPagination<ExampleDto>>> getAllUser(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) throws Exception {
        ResponseGeneral<ListDataPagination<ExampleDto>> response = new ResponseGeneral<>();
        ListDataPagination<ExampleDto> result = new ListDataPagination<>();
        try {
            result = exampleService.getExampleInfo(page, size);
            response.setData(result);
            response.setMessage(AppConstant.MESSAGE_SUCCESS);
            response.setCode(HttpConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "/create-user")
    public ResponseEntity<ResponseGeneral<Boolean>> createUser(@RequestBody ExampleDto request) throws Exception {
        ResponseGeneral<Boolean> response = new ResponseGeneral<>();
        Boolean result;
        try {
            result = exampleService.createUser(request);
            response.setData(result);
            response.setMessage(AppConstant.AUDIT_INSERT);
            response.setCode(HttpConstant.ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit-user")
    public ResponseEntity<ResponseGeneral<Boolean>> editUser(@RequestBody ExampleDto request) throws Exception {
        ResponseGeneral<Boolean> response = new ResponseGeneral<>();
        Boolean result;
        try {
            result = exampleService.editUser(request);
            response.setData(result);
            response.setMessage(AppConstant.AUDIT_UPDATE);
            response.setCode(HttpConstant.ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/users-export")
    public void exportUser(@RequestParam(required = true) ExportType exportType, HttpServletResponse response) throws Exception{
        List<ExampleDto> result = new ArrayList<>();
        String fileName = "ExportExample";
        try {
            result = exampleService.getExampleInfo(0, 100).getList();
            if(ExportType.EXCEL == exportType) {
                exportExcelService.generateReport(response, fileName, exampleService.getUserReportExcel(result, fileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
