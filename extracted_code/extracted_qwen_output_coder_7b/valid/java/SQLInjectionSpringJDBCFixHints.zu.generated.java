import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final SchemaManagerService schemaManagerService;

    @Autowired
    public ProductService(SchemaManagerService schemaManagerService) {
        this.schemaManagerService = schemaManagerService;
    }

    public void initializeProductTable() {
        schemaManagerService.addProductColumn("description", "VARCHAR(255)");
    }
}