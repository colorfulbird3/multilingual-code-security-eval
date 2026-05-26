
 */
public class SchemaManagerService {

    private static final String EXAMPLE_SCHEMA = "exampleschema";
    private static final String EXAMPLE_TABLE = "exampletable";

    private static final String EXAMPLE_DDL_CREATE = "CREATE TABLE IF NOT EXISTS " + EXAMPLE_TABLE + " (" +
            "id INTEGER PRIMARY KEY, " +
            "firstname VARCHAR(255)," +
            "lastname VARCHAR(255)," +
            "email VARCHAR(255)," +
            "phone_number VARCHAR(255)," +
            "country VARCHAR(255))";

    private static final String EXAMPLE_DDL_DROP = "DROP TABLE IF EXISTS " + EXAMPLE_TABLE;

    private static final String EXAMPLE_DDL_INSERT = "INSERT INTO " + EXAMPLE_TABLE + " VALUES(" +
            "2, 'John', 'Doe', 'johndoe@example.com','123-456-7890')";

    private static final String EXAMPLE_DDL_SELECT = "SELECT * FROM " + EXAMPLE_TABLE;

    private static final String EXAMPLE_DDL_DELETE = "DELETE FROM " + EXAMPLE_TABLE;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleschema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaManagerService.class);

    private Session session;
    private Connection connection;
    private TransactionManager transactionManager;
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public static void main(String[] args) {
        SchemaManagerService schemaManagerService = new SchemaManagerService();
        schemaManagerService.executeExample();
    }

    public void executeExample() {
        // Create JDBC template
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        // Create database
        jdbcTemplate