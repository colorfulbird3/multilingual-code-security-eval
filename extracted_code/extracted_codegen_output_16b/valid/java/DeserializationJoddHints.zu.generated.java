import jodd.json.JsonParser;
import java.util.Map;

public class WorkFlowService {
    public Map loadConfig(String jsonConfig) {
        return JsonParser.create().parse(jsonConfig);
    }
}