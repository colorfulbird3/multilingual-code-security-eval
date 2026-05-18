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

public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addProductColumn(String columnName, String columnType) {
        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add column '" + columnName + "' of type '" + columnType + "' to products table.", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```