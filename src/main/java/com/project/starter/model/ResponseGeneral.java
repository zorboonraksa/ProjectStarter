package com.project.starter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGeneral<T> {

    private Integer code;
    private String message;
    private T data;


}

