package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Sales data statistics service
 * Provides functionality to statistically aggregate sales data based on user-specified grouping fields and date ranges
 */
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    /**
     * Statistically aggregates sales data based on the grouping field and date range provided by the user
     * 
     * @param groupByField grouping field, user-controllable input
     * @param dateRange date range, user-controllable input
     * @return list of grouped statistical results
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Validate input parameters
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Grouping field cannot be empty");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Date range cannot be empty");
        }
        
        // Split the date range into start and end date
        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("Invalid date range format. Use: 'start date,end date'");
        }
        
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Validate dates (simple check)
        if (startDate.isEmpty() || endDate.isEmpty()) {
            throw new IllegalArgumentException("Start and end date must be provided");
        }
        
        // Call the mapper to retrieve the data
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}