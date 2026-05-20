@Service
public class ProductService {

    private final SchemaManagerService schemaManagerService;

    public ProductService(SchemaManagerService schemaManagerService) {
        this.schemaManagerService = schemaManagerService;
    }

    public void addNewColumn() {
        schemaManagerService.addProductColumn("new_column", "VARCHAR(255)");
    }
}