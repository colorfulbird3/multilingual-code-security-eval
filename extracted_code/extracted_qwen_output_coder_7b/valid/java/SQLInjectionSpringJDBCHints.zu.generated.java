package com.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 * Service for managing database schema changes.
 * Allows dynamic addition of columns to the products table.
 */
public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructs a new SchemaManagerService with the given DataSource.
     *
     * @param dataSource The data source to use for database operations
     */
    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Adds a new column to the products table.
     *
     * @param columnName The name of the new column
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

        // Sanitize inputs to prevent SQL injection
        String sanitizedColumnName = sanitizeIdentifier(columnName);
        String sanitizedColumnType = sanitizeIdentifier(columnType);

        String sql = "ALTER TABLE products ADD COLUMN " + sanitizedColumnName + " " + sanitizedColumnType;
        jdbcTemplate.execute(sql);
    }

    /**
     * Sanitizes a database identifier to prevent SQL injection.
     * Only allows alphanumeric characters, underscores, and parentheses.
     *
     * @param identifier The identifier to sanitize
     * @return The sanitized identifier
     */
    private String sanitizeIdentifier(String identifier) {
        return identifier.replaceAll("[^a-zA-Z0-9_()]", "");
    }
}