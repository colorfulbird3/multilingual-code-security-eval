`


 */
public class Mapper {
    private Configuration cfg;
    private MapperBuilderAssistant assistant;

    public Mapper(Configuration configuration, MapperBuilderAssistant assistant) {
        this.cfg = configuration;
        this.assistant = assistant;
    }

    public void addMappings() {
        cfg.addMappings(assistant.mapperConfig.getMappings());
    }

    public void addMappedStatement(MappedStatement ms) {
        assistant.addMappedStatement(ms);
    }

    public void addMappedStatement(MappedStatement ms, Object parameterObject) {
        assistant.addMappedStatement(ms, parameterObject);
    }
}
