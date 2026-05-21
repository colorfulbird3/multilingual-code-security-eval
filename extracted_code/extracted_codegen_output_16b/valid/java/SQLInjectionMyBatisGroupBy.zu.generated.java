package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Inkonzo yezibalo zedatha yokuthengisa
 * Inikeza umsebenzi wokuhlaziya izibalo zedatha yokuthengisa ngokusekelwe emikhakheni yokuqoqa kanye nezikhathi zosuku ezinikezwe umsebenzisi
 */
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    /**
     * Hlaziya izibalo zedatha yokuthengisa ngokusekelwe emkhakheni wokuqoqa kanye nesikhathi sosuku ezinikezwe umsebenzisi
     * 
     * @param groupByField umkhakha wokuqoqa, olawulwa umsebenzisi
     * @param dateRange isikhathi sosuku, esilawulwa umsebenzisi
     * @return uhlu lwemiphumela yezibalo eziqoqwe ngamaqembu
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Hlukanisa isikhathi sosuku ukuze uthole usuku lokuqala nolokugcina
        String[] dates = dateRange.split(",");
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Biza i-mapper ukuze uthole izibalo eziqoqwe ngamaqembu
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}