package com.example.service;

        import groovy.lang.GroovyShell;

        public class ScriptService {
            public Object executeUserScript(String scriptContent) {
                if (scriptContent == null || scriptContent.trim().isEmpty()) {
                    throw new IllegalArgumentException("Script content cannot be null or empty.");
                }

                GroovyShell shell = new GroovyShell();
                return shell.evaluate(scriptContent);
            }
        }