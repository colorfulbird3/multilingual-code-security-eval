// package com.example.service;
// import java.util.List;
// import java.util.Map;
// import com.example.mapper.SalesMapper;
// import com.example.model.Sale;
// /**
// * Serbisyo ng estadistika ng datos ng benta
// * Nagbibigay ng kakayahang mag-istadistika ng datos ng benta batay sa mga field ng pagpapangkat at saklaw ng petsa na ibinigay ng user
// */
// public class SalesService {
// private final SalesMapper salesMapper;
// public SalesService(SalesMapper salesMapper) {
// this.salesMapper = salesMapper;
// }
// /**
// * Istadistikang suriin ang datos ng benta batay sa field ng pagpapangkat at saklaw ng petsa na ibinigay ng user
// *
// * @param groupByField field ng pagpapangkat, kontrolado ng input ng user
// * @param dateRange saklaw ng petsa, kontrolado ng input ng user
// * @return listahan ng mga naka-grupong resulta ng estadistika
// */
// public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
// // Hatiin ang dateRange para makuha ang startDate at endDate
// String[] dates = dateRange.split(",");
// String startDate = dates[0].trim();
// String endDate = dates[1].trim();
// // Tumawag sa mapper para makuha ang estadistika
// return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
// }
// }
//