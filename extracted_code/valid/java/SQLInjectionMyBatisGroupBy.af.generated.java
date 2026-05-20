package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Sales data statistics service
 * Provides functionality to extract sales data statistics based on user-provided grouping fields and date ranges
 */
public class SalesService {

    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    /**
     * Extracts sales data statistics based on user-provided grouping field and date range
     * 
     * @param groupByField grouping field, manageable by user input
     * @param dateRange date range, manageable by user input
     * @return list of grouped statistical results
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Validate input parameters
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Grouping field must not be empty");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Date range must not be empty");
        }
        
        // Split the date range into start and end date
        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("Invalid date range format. Use 'start date,end date'");
        }
        
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Validate that the grouping field is valid
        List<String> validFields = List.of("region", "product_category", "sales_person");
        if (!validFields.contains(groupByField)) {
            throw new IllegalArgumentException("Invalid grouping field: " + groupByField);
        }
        
        // Call the mapper to get the data
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}