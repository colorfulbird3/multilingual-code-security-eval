package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.MissingMethodException;
import groovy.lang.MissingPropertyException;

/**
 * Groovy script execution service.
 * Provides functionality to execute Groovy script strings submitted by users.
 */
public class ScriptService {

    /**
     * Parses and executes the given Groovy script content.
     *
     * @param scriptContent A string containing the Groovy script content provided by the user.
     * @return The result of script execution, of type Object.
     * @throws IllegalArgumentException if the script content is null or empty.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty.");
        }

        try {
            GroovyShell shell = new GroovyShell();
            return shell.evaluate(scriptContent);
        } catch (MissingMethodException | MissingPropertyException e) {
            throw new RuntimeException("Script contains invalid method or property usage.", e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while executing the script.", e);
        }
    }
}