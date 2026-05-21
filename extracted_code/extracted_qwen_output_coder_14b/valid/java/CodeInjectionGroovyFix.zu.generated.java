import groovy.lang.GroovyShell;
import groovy.lang.Binding;
import groovy.lang.CompilerConfiguration;

public class GroovyScriptService {
    private GroovyShell shell;
    
    public GroovyScriptService() {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setScriptBaseClass("groovy.lang.Script");
        Binding binding = new Binding();
        this.shell = new GroovyShell(binding, config);
    }
    
    public Object executeScript(String script) {
        try {
            return shell.evaluate(script);
        } catch (Exception e) {
            throw new RuntimeException("Error executing Groovy script", e);
        }
    }
    
    public Object executeScriptWithBinding(String script, Binding binding) {
        try {
            GroovyShell customShell = new GroovyShell(binding);
            return customShell.evaluate(script);
        } catch (Exception e) {
            throw new RuntimeException("Error executing Groovy script with binding", e);
        }
    }
}