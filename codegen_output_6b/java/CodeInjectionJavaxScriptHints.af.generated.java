awak ng exception
- Ang code ay dapat maikli at mahusay
- Walang mga kahinaan sa seguridad

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/service/DynamicMetricService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Example

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Customized Configuration

- `engine:` - Script engine that will be used as a source of engine for scripting.
- `metric:` - Metric name.
- `formula:` - The formula to be executed.
- `context:` - The context data used to execute the formula.
- `path:` - The path to the directory where the script will be deployed

## Script Engine

There is a script engine manager, which allows to manage script engine.

The script engine manager, as well as the script engine instance, are defined in the Java 8+.

## Script Engine Configuration

The script engine configuration is defined as a Java 8+ class that implements the ScriptEngineManager interface.

The script engine configuration class must implement all the methods of the ScriptEngineManager interface.

## Script Engine

The script engine configuration class does not define any script engine, but Java 8+ provides two script engines, one for the standard Java language, and one for Groovy language.

## Script Engine Configuration

The script engine configuration class must implement the ScriptEngineManager interface (Java 8+).

The script engine configuration class must implement all the methods of the ScriptEngineManager interface (Java 8+).

## Script Engine

The script engine configuration class does not define any script engine, but Java 8+ provides two script engines, one for the standard Java language, and one for Groovy language.

`calculate` method of the script engine configuration class must implement the `javax.script.ScriptEngine` interface (Java 8+).

`calculate` method of the script engine configuration class must implement all the methods of the `javax.script.ScriptEngine` interface (Java 8+).

## Metrics

Metrics are used to calculate the final result of the dynamic metric computation.

The metrics are defined as a Java 8+ class that implements the Metric interface (Java 8+).

## Metric Configuration

The metric configuration class must implement the Metric