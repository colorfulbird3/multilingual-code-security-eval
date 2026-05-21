@Service
public class ProductService {

    private final SchemaManagerService schemaManagerService;

    @Autowired
    public ProductService(SchemaManagerService schemaManagerService) {
        this.schemaManagerService = schemaManagerService;
    }

    public void addDescriptionColumn() {
        schemaManagerService.addProductColumn("description", "VARCHAR(255)");
    }
}