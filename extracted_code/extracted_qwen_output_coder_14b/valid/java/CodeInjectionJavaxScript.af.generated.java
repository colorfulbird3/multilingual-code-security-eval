package com.example.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class DynamicMetricService {

    public Object calculate(String formula, Map<String, Object> context) throws ScriptException {
        // Maak 'n ScriptEngineManager-insansie
        ScriptEngineManager manager = new ScriptEngineManager();
        // Verkry 'n JavaScript-engine
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Voeg die konteksveranderlikes by die engine
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            engine.put(entry.getKey(), entry.getValue());
        }

        // Evalueer die formule
        return engine.eval(formula);
    }
}