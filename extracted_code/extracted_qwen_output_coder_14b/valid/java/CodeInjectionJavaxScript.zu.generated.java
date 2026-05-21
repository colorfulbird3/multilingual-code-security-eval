package com.example.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class DynamicMetricService {

    public Object calculate(String formula, Map<String, Object> context) throws ScriptException {
        // Create a script engine manager
        ScriptEngineManager manager = new ScriptEngineManager();
        // Get a JavaScript engine
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Bind the context to the engine
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            engine.put(entry.getKey(), entry.getValue());
        }

        // Evaluate the formula
        return engine.eval(formula);
    }
}