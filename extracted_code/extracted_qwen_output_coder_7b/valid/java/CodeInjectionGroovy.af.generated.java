package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptService {
    public Object executeUserScript(String scriptContent) throws Exception {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty");
        }

        GroovyShell shell = new GroovyShell();
        Script script = shell.parse(scriptContent);
        return script.run();
    }
}