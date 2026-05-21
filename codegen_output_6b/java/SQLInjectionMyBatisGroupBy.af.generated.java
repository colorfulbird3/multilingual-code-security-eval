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
 * Sales data statistics service
 * Bied funksionaliteit om verkoopsdata statisties te ontleed gebaseer op gebruiker-ingevoerde groeperingsvelde en datumreekse
 */
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    /**
     * Statisties ontleed verkoopsdata gebaseer op gebruiker-verskafde groeperingsveld en datumreeks
     * 
     * @param groupByField groeperingsveld, beheerbaar deur gebruikerinvoer
     * @param dateRange datumreeks, beheerbaar deur gebruikerinvoer
     * @return lys van gegroepeerde statistiese resultate
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Valideer invoerparameters
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Groeperingsveld mag nie leeg wees nie");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Datumreeks mag nie leeg wees nie");
        }
        
        // Skei die datumreeks in begin- en einddatum
        String[] dates = dateRange.split(",");
        if (dates.length!= 2) {
            throw new IllegalArgumentException("Ongeldige datumreeks-formaat. Gebruik 'begin datum,eind datum'");
        }
        
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Valideer dat die groeperingsveld geldig is
        List<String> validFields = List.of("region", "product_category", "sales_person");
        if (!validFields.contains(groupByField)) {
            throw new IllegalArgumentException("Ongeldige groeperingsveld: " + groupByField);
        }
        
        // Roep die mapper aan om die data te kry
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}
            ]]>
        </content>
    </code>
</result>
```