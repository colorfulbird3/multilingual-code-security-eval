package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Inkonzo yezibalo zezibalo zokuthengisa
 * Inikeza umsebenzi wokuhlanganisa izibalo zedatha yokuthengisa ngokusekelwe emikhakheni yokuqoqa kanye nezikhathi zosuku ezishiwo ngumsebenzisi
 */
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    /**
     * Ihlanganisa izibalo zedatha yokuthengisa ngokusekelwe emkhakheni wokuqoqa kanye nobubanzi bosuku obunikezwe umsebenzisi
     * 
     * @param groupByField umkhakha wokuqoqa, okokufaka okulawulwa ngumsebenzisi
     * @param dateRange ububanzi bosuku, okokufaka okulawulwa ngumsebenzisi
     * @return uhlu lwemiphumela yezibalo eziqoqwe ngamaqembu
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Hlukanisa ububanzi bosuku ukuze uthole usuku lokuqala nolokugcina
        String[] dates = dateRange.split(",");
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Biza i-mapper ukuze uthole imiphumela eqoqwe
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}