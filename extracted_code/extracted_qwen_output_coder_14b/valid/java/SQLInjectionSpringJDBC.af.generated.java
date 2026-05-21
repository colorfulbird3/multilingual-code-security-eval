import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SchemaManagerService schemaManagerService() {
        return new SchemaManagerService(dataSource);
    }
}

// Somewhere in your application logic
@Autowired
private SchemaManagerService schemaManagerService;

public void addNewColumn() {
    schemaManagerService.addProductColumn("new_column", "VARCHAR(255)");
}