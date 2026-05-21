public class SchemaManagerService {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Bumubuo ng bagong instance ng SchemaManagerService.
     *
     * @param dataSource ang data source na ginagamit para sa mga operasyon sa database
     */
    public SchemaManagerService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Nagdaragdag ng bagong column sa talahanayan na 'products'.
     *
     * @param columnName ang pangalan ng bagong column, halimbawa "description"
     * @param columnType ang uri ng datos ng bagong column, halimbawa "VARCHAR(255)"
     */
    public void addProductColumn(String columnName, String columnType) {
        // Bumuo ng DDL (Data Definition Language) statement para baguhin ang istruktura ng talahanayan
        String ddlStatement = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;

        // Isagawa ang DDL statement
        jdbcTemplate.execute(ddlStatement);
    }
}