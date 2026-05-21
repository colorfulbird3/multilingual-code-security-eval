```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/SalesService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Sales Data Statistics Service
 * Provides functionality to statistically analyze sales data based on user-provided grouping fields and date ranges
 */
public class SalesService {

    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    /**
     * Statistically analyze sales data based on user-provided grouping field and date range
     *
     * @param groupByField grouping field, user-controllable input
     * @param dateRange date range, user-controllable input
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

        // Validate that the groupByField is one of the allowed values
        List<String> validFields = List.of("region", "product_category", "sales_person");
        if (!validFields.contains(groupByField)) {
            throw new IllegalArgumentException("Invalid grouping field; must be one of " + validFields);
        }

        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}
            ]]>
        </content>
    </code>
</result>
```