package com.project.starter.service.model;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDataPagination <T> {
    private List<T> list = new ArrayList<>();
    private Integer total;
}
