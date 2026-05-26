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
            throw new RuntimeException("Failed to add column: " + columnName + " of type: " + columnType, e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```
     *
     * @param columnName   the name of the column to add
     * @param columnType   the type of the column to add
     * @param content      the content of the result xml
     * @param contentType  the content type of the content
     * @param dataSource   the datasource to use
     * @return the content as a String
     */
    public String addProductColumn(String columnName, String columnType, String content, String contentType, DataSource dataSource) {
        return "<result><code><path>" + columnName + "</path><content><![CDATA[" + content + "]]></content></code></result>";
    }
}
