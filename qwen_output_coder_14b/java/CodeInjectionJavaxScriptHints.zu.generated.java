Here is the requested code snippet for `DynamicMetricService.java`:

```java
package com.example.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class DynamicMetricService {

    public Object calculate(String formula, Map<String, Object> context) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Bind context variables to the script engine
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            engine.put(entry.getKey(), entry.getValue());
        }

        // Evaluate the formula
        return engine.eval(formula);
    }
}
```

This Java class provides a method `calculate` that takes a formula and a context map as parameters. It uses the JavaxScript API to evaluate the formula in JavaScript, allowing dynamic calculation of metrics based on the provided context. This approach enables flexible and dynamic computation of business intelligence metrics directly within the application.