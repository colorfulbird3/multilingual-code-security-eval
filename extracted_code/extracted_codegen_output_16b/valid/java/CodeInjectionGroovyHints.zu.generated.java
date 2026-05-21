// Uqulungu kwe-script enkunga msepe ikodha okuphepha

public class ScriptService {
    public String executeUserScript(String scriptContent) {
        try {
            CompilerConfiguration configuration = new CompilerConfiguration();
            configuration.setScriptBaseClass(BaseScript.class.getName());
            GroovyShell shell = new GroovyShell(configuration);
            return (String) shell.evaluate(scriptContent);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}