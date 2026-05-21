```java
package com.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import javax.sql.DataSource;

public class SchemaManagerService {
    private final JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addProductColumn(String columnName, String columnType) {
        if (columnName == null || columnName.trim().isEmpty()) {
            throw new IllegalArgumentException("Column name must not be null or empty");
        }
        if (columnType == null || columnType.trim().isEmpty()) {
            throw new IllegalArgumentException("Column type must not be null or empty");
        }

        String safeColumnName = sanitizeIdentifier(columnName);
        String safeColumnType = sanitizeIdentifier(columnType);

        String sql = "ALTER TABLE products ADD COLUMN " + safeColumnName + " " + safeColumnType;
        jdbcTemplate.execute(sql);
    }

    private String sanitizeIdentifier(String identifier) {
        return identifier.replaceAll("[^a-zA-Z0-9_()]", "");
    }
}
```