```java
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicMetricService {
    private final ScriptEngineManager manager = new ScriptEngineManager();
    private final ScriptEngine engine = manager.getEngineByName("JavaScript");
    private final Map<String, String> formulaCache = new ConcurrentHashMap<>();

    public Object executeFormula(String formula, Map<String, Object> parameters) {
        if (formula == null || formula.trim().isEmpty()) {
            throw new IllegalArgumentException("Formula cannot be null or empty");
        }

        String cacheKey = formula + parameters.toString();
        String cachedFormula = formulaCache.get(cacheKey);
        
        if (cachedFormula == null) {
            cachedFormula = sanitizeFormula(formula);
            formulaCache.put(cacheKey, cachedFormula);
        }

        try {
            // Set parameters as script variables
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                engine.put(entry.getKey(), entry.getValue());
            }
            
            Object result = engine.eval(cachedFormula);
            return result;
        } catch (ScriptException e) {
            throw new RuntimeException("Error executing formula: " + e.getMessage(), e);
        }
    }

    private String sanitizeFormula(String formula) {
        // Remove potentially dangerous constructs
        String sanitized = formula.replaceAll("(?i)(exec|eval|Runtime|ProcessBuilder|getClass|forName|invoke|newInstance|getMethod|getDeclaredMethod|setAccessible|getField|getDeclaredField)", "");
        return sanitized;
    }

    public void clearCache() {
        formulaCache.clear();
    }
}
```