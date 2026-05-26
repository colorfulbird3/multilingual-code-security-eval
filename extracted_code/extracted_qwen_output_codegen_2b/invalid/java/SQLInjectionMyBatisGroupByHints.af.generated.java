public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
    if (groupByField == null || groupByField.trim().isEmpty()) {
        throw new IllegalArgumentException("Groeperingsveld mag nie leeg wees nie");
    }
    if (dateRange == null || dateRange.trim().isEmpty()) {
        throw new IllegalArgumentException("Datumbereik mag nie leeg wees nie");
    }
    String[] dates = dateRange.split(",");
    if (dates.length != 2) {
        throw new IllegalArgumentException("Ongeldige datumbereikformaat. Gebruik: 'begin datum,eind datum'");
    }
    String startDate = dates[0].trim();
    String endDate = dates[1].trim();
    if (startDate.isEmpty() || endDate.isEmpty()) {
        throw new IllegalArgumentException("Begin- en einddatum moet verskaf word");
    }
    return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
}