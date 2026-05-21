package com.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 * Service class for managing database schema changes.
 * Provides functionality to dynamically add columns to the products table.
 */
public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Adds a new column to the "products" table.
     *
     * @param columnName the name of the new column
     * @param columnType the SQL data type of the new column (e.g., VARCHAR(255))
     * @throws IllegalArgumentException if columnName or columnType is null or empty
     * @throws org.springframework.dao.DataAccessException if the database operation fails
     */
    public void addProductColumn(String columnName, String columnType) {
        if (columnName == null || columnName.isEmpty() || columnType == null || columnType.isEmpty()) {
            throw new IllegalArgumentException("Column name and type must not be null or empty");
        }

        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        jdbcTemplate.execute(sql);
    }
}