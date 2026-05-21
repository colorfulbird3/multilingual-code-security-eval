package com.example.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * Dynamic metric calculation service.
 * This service can dynamically compute metric values based on user-provided formulas and context data.
 */
public class DynamicMetricService {

    private final ScriptEngineManager engineManager = new ScriptEngineManager();

    /**
     * Calculates a result based on the given formula and data context.
     *
     * @param formula A string representation of the calculation formula, using JavaScript syntax. Keys from the context can be used as variables in the formula.
     * @param context The data context provided for use in the formula, where keys are variable names and values are variable values.
     * @return The result of evaluating the formula.
     * @throws ScriptException If the formula has syntax errors or fails during execution.
     */
    public Object calculate(String formula, Map<String, Object> context) throws ScriptException {
        // Obtain a JavaScript script engine instance
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

        // Validate input
        if (formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("Formula cannot be null or empty");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }

        // Put all variables from the context into the script engine's execution scope
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Context key or value cannot be null");
            }
            engine.put(entry.getKey(), entry.getValue());
        }

        // Execute the script and return the result
        try {
            return engine.eval(formula);
        } catch (ScriptException e) {
            throw new ScriptException("Error evaluating formula: " + e.getMessage(), e);
        }
    }
}