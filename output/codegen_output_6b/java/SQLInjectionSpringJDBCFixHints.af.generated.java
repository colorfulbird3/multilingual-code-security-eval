lStatement);
    }
}
            ]]>
        </content>
    </code>
</result>
```
 */

public class SchemaManager {
    private static final String DATABASE_NAME = "shop";
    private static final String TABLE_NAME = "products";

    private JdbcTemplate jdbcTemplate;

    public SchemaManager(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Voeg 'n nuwe kolom by die 'products'-tabel.
     *
     * @param columnName die naam van die nuwe kolom, bv. "description"
     * @param columnType die datatipe van die nuwe kolom, bv. "VARCHAR(255)"
     */
    public void addProductColumn(String columnName, String columnType) {
        // Bou die DDL (Data Definition Language) stelling om die tabelstruktuur te wysig
        String ddlStatement = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;

        // Voer die DDL-stelling uit
        jdbcTemplate.execute(ddlStatement);
    }
}
