package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.MissingMethodException;

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
     * @throws RuntimeException If an error occurs during script execution.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty.");
        }

        GroovyShell shell = new GroovyShell();
        try {
            return shell.evaluate(scriptContent);
        } catch (MissingMethodException e) {
            throw new RuntimeException("A method call in the script is missing: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while executing the script: " + e.getMessage(), e);
        }
    }
}