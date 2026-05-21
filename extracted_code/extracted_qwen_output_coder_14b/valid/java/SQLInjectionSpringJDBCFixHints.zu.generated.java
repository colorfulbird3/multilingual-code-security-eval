package com.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 * Inkonzo ehlinzeka ngokuphathwa kwesakhiwo sedatha.
 */
public class SchemaManagerService {
    private JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addProductColumn(String columnName, String columnType) {
        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        jdbcTemplate.execute(sql);
    }
}