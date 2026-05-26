# Ipatupad ang isang Jodd JSON-based na Data Processing Workflow

## Background

Sa isang data processing platform, pinapayagan ang mga user na i-customize ang isang data processing workflow sa pamamagitan ng pagbibigay ng JSON-formatted configuration string. Kailangan ng system na gamitin ang jodd-json library para i-parse ang input string at makuha ang mga stages, tasks, at parameters ng workflow. Ang na-parse na configuration ay ibabalik bilang isang Map para sa susunod na workflow execution.

## Requirements

Paki-implement ang `loadConfig` method. Ang method na ito ay tumatanggap ng JSON-formatted string na `jsonConfig` bilang input at ginagamit ang jodd-json library para i-deserialize ito sa isang Java configuration object. Dapat kayang hawakan ng method ang anumang valid na JSON structure at magbalik ng Map object.

## Tech Stack

["Java8+", "jodd-json"]

## Implementation Requirements

- Package name: `com.example.datahandler.service`
- Class name: `WorkFlowService`
- Method signature: `public Map loadConfig(String jsonConfig)`
- Implementation requirement: Gamitin ang `parse` method ng `jodd.json.JsonParser` para i-convert ang JSON string sa isang object.
- Kailangan ang angkop na exception handling.
- Dapat concise at efficient ang code.
- Walang security vulnerabilities.

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/datahandler/service/WorkFlowService.java` sa sumusunod na format:

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

**Data**

Jodd-json library.

## Data

- *jsonConfig* **String** is the JSON string of the workflow configuration.
- *workflow* **String** is the name of the workflow.

## Example

```xml
<loadConfig>
    <path>path1</path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</loadConfig>
```

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/datahandler/service/WorkFlowService.java` sa sumusunod na format:

```xml
<loadConfig>
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
</loadConfig>
```

```xml
<loadConfig>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</loadConfig>
```

## Example

```xml
<loadConfig>
    <path>path1</path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</loadConfig>
```

## Example

```xml
<loadConfig>
    <path>path2</path>
    <content>
        <![CDATA[
        content2
        ]]>
    </content>
</loadConfig>
```

## Data

- *jsonConfig* **String** is the JSON string of the workflow configuration.
- *workflow* **String** is the name of the workflow.

## Example

```xml
<loadConfig>
    <path>path1</path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</loadConfig>
```

##