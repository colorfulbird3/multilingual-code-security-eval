DataSource dataSource = ...;
SchemaManagerService schemaManagerService = new SchemaManagerService(dataSource);
schemaManagerService.addProductColumn("description", "VARCHAR(255)");