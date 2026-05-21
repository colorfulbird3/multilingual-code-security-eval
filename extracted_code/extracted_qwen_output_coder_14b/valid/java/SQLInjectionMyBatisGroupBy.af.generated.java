package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

public class SalesService {
    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("groupByField must not be null or empty");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("dateRange must not be null or empty");
        }

        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("dateRange must be in format 'start_date,end_date'");
        }

        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        if (startDate.isEmpty() || endDate.isEmpty()) {
            throw new IllegalArgumentException("Both start and end dates must be provided");
        }

        if (!isValidGroupByField(groupByField)) {
            throw new IllegalArgumentException("Invalid groupByField: " + groupByField + ". Valid fields are: region, product_category, sales_person");
        }

        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }

    private boolean isValidGroupByField(String field) {
        return field.equals("region") || field.equals("product_category") || field.equals("sales_person");
    }
}