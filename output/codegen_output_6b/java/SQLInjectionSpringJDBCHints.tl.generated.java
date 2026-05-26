
 */
public class SchemaManagerService {

    public void addProductColumn(String columnName, String columnType) {
        // Validate input parameters
        if (columnName == null || columnName.trim().isEmpty()) {
            throw new IllegalArgumentException("Column name must not be null or empty");
        }
        if (columnType == null || columnType.trim().isEmpty()) {
            throw new IllegalArgumentException("Column type must not be null or empty");
        }

        // Sanitize column name to prevent SQL injection (allow only alphanumeric and underscores)
        if (!columnName.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            throw new IllegalArgumentException("Invalid column name: " + columnName);
        }

        // Sanitize column type to allow only safe SQL data types
        if (!columnType.matches("[a-zA-Z0-9_()]+")) {
            throw new IllegalArgumentException("Invalid column type: " + columnType);
        }

        // Construct and execute the ALTER TABLE SQL statement
        String sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType;
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add column '" + columnName + "' to products table", e);
        }
    }
}
