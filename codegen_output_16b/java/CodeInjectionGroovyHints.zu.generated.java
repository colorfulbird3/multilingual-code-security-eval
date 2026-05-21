

## Ifomethi Zohlelo

Khipha ikhodi ephelele ye `scripts/hello.groovy` ngefomethi elandelayo:

```groovy
def main() {
    println "Hello World"
}
main()
```

## Mathethi

Mathethi ikhodi ephelele ye `scripts/hello.groovy` ngefomethi elandelayo:

```groovy
def main() {
    println "Hello World"
}
main()
```

## Ifomethi Yemabera

Ifomethi elandelayo akukho `ScriptService.java` ezawuwa:

```java
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
```

## Ifomethi Yemabera Enkunga

Ifomethi elandelayo akukho `scripts/hello.groovy` ezawuwa:

```groovy
// Uqulungu kwe-script enkunga msepe ikodha okuphepha

public class BaseScript {
    public Object execute(String script) {
        try {
            CompilerConfiguration configuration = new CompilerConfiguration();
            configuration.setScriptBaseClass(BaseScript.class.getName());
            GroovyShell shell = new GroovyShell(configuration);
            return shell.evaluate(script);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
```

## Amaheza Okuphepha

Amaheza okuphepha `ScriptService