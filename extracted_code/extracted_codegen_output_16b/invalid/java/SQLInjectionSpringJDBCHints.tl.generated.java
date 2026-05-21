def add_products_column(self, columnName, columnType):
    # Validate input parameters
    if columnName == None or columnName.strip() == "":
        raise IllegalArgumentException("Column name must not be null or empty")
    if columnType == None or columnType.strip() == "":
        raise IllegalArgumentException("Column type must not be null or empty")

    # Sanitize column name to prevent SQL injection (allow only alphanumeric and underscores)
    if not columnName.matches("[a-zA-Z_][a-zA-Z0-9_]*"):
        raise IllegalArgumentException("Invalid column name: " + columnName)

    # Sanitize column type to allow only safe SQL data types
    if not columnType.matches("[a-zA-Z0-9_()]+"):
        raise IllegalArgumentException("Invalid column type: " + columnType)

    # Construct and execute the ALTER TABLE SQL statement
    sql = "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType
    self.jdbcTemplate.execute(sql)