     * 
     * @param groupByField field ng pagpapangkat, kontrolado ng input ng user
     * @param dateRange saklaw ng petsa, kontrolado ng input ng user
     * @return listahan ng mga naka-grupong resulta ng estadistika
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // Hatiin ang dateRange para makuha ang startDate at endDate
        String[] dates = dateRange.split(",");
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // Tumawag sa mapper para makuha ang estadistika
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}
            ]]>
        </content>
    </code>
</result>
```
*/
