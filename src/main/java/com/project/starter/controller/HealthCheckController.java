package com.project.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/project/healthCheck")
public class HealthCheckController {
    @GetMapping
    public Map<String,String> healthCheck() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Status", "Success");
        map.put("StatusDesc", "Health-Check service (Starter) is Running");

        return map;
    }
}
