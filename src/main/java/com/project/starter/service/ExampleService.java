package com.project.starter.service;

import com.project.starter.dao.ExampleDao;
import com.project.starter.dto.ExampleDto;
import com.project.starter.service.model.ListDataPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleService {

    private final ExampleDao exampleDao;

    @Autowired
    public ExampleService(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
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
}
