
        </content>
    </code>
</result>
```
 */

public class SchemaManagerService {
    private JdbcTemplate jdbcTemplate;

    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addProductColumn(String columnName, String columnType) {
        // Bumuo ng DDL (Data Definition Language) statement para baguhin ang istruktura ng talahanayan
        String ddlStatement = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;

        // Isagawa ang DDL statement
        jdbcTemplate.execute(ddlStatement);
    }
}
