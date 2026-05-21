package com.example.service;

import java.util.List;
import java.util.Map;
import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Verkoopsdata Statistiekdiens
 * Bied funksionaliteit om verkoopsdata statisties te ontleed gebaseer op gebruikersgespesifiseerde groeperingsvelde en datumreekse
 */
public class SalesService {

    private final SalesMapper salesMapper;

    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }

    /**
     * Statisties ontleed verkoopsdata gebaseer op gebruiker-verskafde groeperingsveld en datumreeks
     *
     * @param groupByField groeperingsveld, beheerbaar deur gebruikertoevoer
     * @param dateRange datumreeks, beheerbaar deur gebruikertoevoer
     * @return lys van gegroepeerde statistiese resultate
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Groeperingsveld kan nie leeg wees nie");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Datumreeks kan nie leeg wees nie");
        }

        String[] dates = dateRange.split(",");
        if (dates.length != 2) {
            throw new IllegalArgumentException("Ongeldige datumreeksformaat; moet 'begin_datum,eind_datum' wees");
        }
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();

        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}