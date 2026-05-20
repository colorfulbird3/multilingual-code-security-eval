public Object calculate(String formula, Map<String, Object> context) throws ScriptException {
    // Obtain a JavaScript script engine instance
    ScriptEngine engine = engineManager.getEngineByName("nashorn");

    // Put all variables from the context into the script engine's execution scope
    if (context != null) {
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            engine.put(entry.getKey(), entry.getValue());
        }
    }

    // Execute the script and return the result
    return engine.eval(formula);
}