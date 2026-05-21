package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * Groovy script execution service.
 * Provides functionality to execute user-submitted Groovy script strings.
 */
public class ScriptService {

    /**
     * Parses and executes the given Groovy script content.
     *
     * @param scriptContent A string containing the user-provided Groovy script content.
     * @return The execution result of the script, of type Object.
     * @throws IllegalArgumentException If the script content is null or empty.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty.");
        }

        GroovyShell shell = new GroovyShell();
        try {
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new RuntimeException("Error executing script", e);
        }
    }
}