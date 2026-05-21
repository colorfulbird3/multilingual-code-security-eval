DataSource dataSource = ...; // Obtain DataSource from configuration
SchemaManagerService schemaManagerService = new SchemaManagerService(dataSource);

try {
    schemaManagerService.addProductColumn("new_column", "VARCHAR(255)");
} catch (IllegalArgumentException | RuntimeException e) {
    System.err.println(e.getMessage());
}