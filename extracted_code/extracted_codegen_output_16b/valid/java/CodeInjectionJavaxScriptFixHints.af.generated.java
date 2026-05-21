```java
package com.example.service;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class DynamicMetricService {

    private final ScriptEngineManager engineManager = new ScriptEngineManager();
    private final ScriptEngine engine = engineManager.getEngineByName("JavaScript");

    public MetricResult calculate(MetricDto metricDto) {
        try {
            Object result = engine.eval(metricDto.getExpression());
            return new MetricResult(result.toString());
        } catch (ScriptException e) {
            throw new RuntimeException("Failed to evaluate expression", e);
        }
    }
}
```