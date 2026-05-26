example/service/ConfigService.java` sa sumusunod na format:

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

### Testing

- Run `mvn exec:java -Dexec.mainClass=com.example.service.ConfigService -Dexec.args='-jsonConfig=<jsonConfig> -jsonOutput=<jsonOutput>'`, where `<jsonConfig>` is an JSON-formatted file containing all the configuration.
- `<jsonOutput>` is a path to a file where the generated JSON-formatted string from Flexjson library will be saved.
- I-test the generated JSON string.

```
<xml>
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
</xml>
```


## Development

- [ ] Implement the `loadConfig` method
- [ ] Implement the `loadConfig` method
- [ ] Implement the `deserialize` method

"""
