 ```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/SchemaManagerService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 * Service class for managing database schema changes.
 * Provides functionality to dynamically add columns to the products table.
 */
public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor that initializes the service with a DataSource.
     *
     * @param dataSource The data source to be used for database operations
     */
    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Adds a new column to the products table dynamically.
     *
     * @param columnName The name of the new column to be added
     * @param columnType The SQL data type of the new column (e.g., VARCHAR(255))
     * @throws IllegalArgumentException if columnName or columnType is null or empty
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