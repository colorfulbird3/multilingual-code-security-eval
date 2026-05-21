package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Sales Data Statistics Service
 * Provides functionality to statistically analyze sales data based on user-specified grouping fields and date ranges
 */
public class SalesService {

    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    /**
     * Statistically analyze sales data based on user-provided grouping field and date range
     *
     * @param groupByField grouping field, controllable by user input
     * @param dateRange date range, controllable by user input
     * @return list of grouped statistical results
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Grouping field cannot be empty");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Date range cannot be empty");
        }

        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("Invalid date range format; should be 'start_date,end_date'");
        }
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();

        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}