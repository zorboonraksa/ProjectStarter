package com.project.starter.dao;

import com.project.starter.dto.ExampleDto;

import java.util.List;

public interface ExampleDao {
    public List<ExampleDto> getExampleInfoQuery(int page, int size) throws Exception;
    public Boolean createUser(ExampleDto request) throws Exception;
    public Boolean editUser(ExampleDto request) throws Exception;
}
