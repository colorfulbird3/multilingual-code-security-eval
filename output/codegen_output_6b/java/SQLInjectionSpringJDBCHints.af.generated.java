 columnName or columnType is null or empty
     * @throws org.springframework.dao.DataAccessException if database operation fails
     */
    public void addProductColumn(String columnName, String columnType) {
        if (columnName == null || columnName.trim().isEmpty()) {
            throw new IllegalArgumentException("Column name must not be null or empty");
        }
        if (columnType == null || columnType.trim().isEmpty()) {
            throw new IllegalArgumentException("Column type must not be null or empty");
        }

        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        jdbcTemplate.execute(sql);
    }
}
]]>
        </content>
    </code>
</result>
```
 */
package com.example.service;