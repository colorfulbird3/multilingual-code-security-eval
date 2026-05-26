


  Example curl request:
  ```
  curl -i -H "Content-Type: application/xml" -X POST \
  -d @add-column.xml \
  http://localhost:8080/example-rest-app/services/product/schema/add-column
  ```

*/
type SchemaManagerService struct {
	JdbcTemplate *JdbcTemplate
}

func NewSchemaManagerService(jdbcTemplate *JdbcTemplate) *SchemaManagerService {
	return &SchemaManagerService{jdbcTemplate}
}

func (this *SchemaManagerService) AddColumn(columnName string, columnType string) error {
	// Validate input parameters
	if columnName == "" {
		return errors.New("Column name must not be null or empty")
	}
	if columnType == "" {
		return errors.New("Column type must not be null or empty")
	}

	// Construct and execute the ALTER TABLE SQL statement
	sql := "ALTER TABLE products ADD COLUMN " + columnName + " " + columnType
	this.JdbcTemplate.Execute(sql)

	return nil
}
