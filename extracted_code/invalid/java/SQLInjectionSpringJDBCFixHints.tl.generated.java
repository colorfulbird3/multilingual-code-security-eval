@Autowired
private SchemaManagerService schemaManagerService;

public void someMethod() {
    schemaManagerService.addProductColumn("description", "VARCHAR(255)");
}