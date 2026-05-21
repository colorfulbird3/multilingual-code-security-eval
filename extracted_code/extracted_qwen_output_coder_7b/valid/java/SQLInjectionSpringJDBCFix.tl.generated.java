@Service
public class SomeOtherService {

    private final SchemaManagerService schemaManagerService;

    public SomeOtherService(SchemaManagerService schemaManagerService) {
        this.schemaManagerService = schemaManagerService;
    }

    public void someMethod() {
        schemaManagerService.addProductColumn("description", "VARCHAR(255)");
    }
}