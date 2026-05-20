```java
package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SalesService {
    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("The group by field cannot be empty");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("The date range cannot be empty");
        }

        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("The date range format should be 'start date,end date'");
        }

        String startDate = dates[0].trim();
        String endDate = dates[1].trim();

        List<String> validFields = Arrays.asList("region", "product_category", "sales_person");
        if (!validFields.contains(groupByField)) {
            throw new IllegalArgumentException("Invalid group by field: " + groupByField);
        }

        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}
```