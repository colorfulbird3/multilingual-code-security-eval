package com.example.service;

import com.example.mapper.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesService {

    @Autowired
    private SalesMapper salesMapper;

    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        String[] dates = dateRange.split(",");
        String startDate = dates[0];
        String endDate = dates[1];
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}