public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
    String[] dates = dateRange.split(",");
    String startDate = dates[0].trim();
    String endDate = dates[1].trim();
    return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
}