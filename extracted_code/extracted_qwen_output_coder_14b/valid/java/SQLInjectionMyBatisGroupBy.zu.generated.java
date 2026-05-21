```java
package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Service class for handling sales-related business logic.
 */
public class SalesService {
    private final SalesMapper salesMapper;

    /**
     * Constructor for SalesService.
     * @param salesMapper the mapper for sales data access
     */
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    /**
     * Retrieves sales data grouped by a specified field within a given date range.
     * @param groupByField the field to group sales data by (e.g., "region", "product")
     * @param dateRange the date range in the format "startDate,endDate"
     * @return a list of maps representing grouped sales data
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        String[] dates = dateRange.split(",");
        String startDate = dates[0];
        String endDate = dates[1];
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}
```