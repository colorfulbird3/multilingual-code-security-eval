    /**
     * Default constructor required for deserialization frameworks.
     */
    public UserPreferences() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}```


## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/config/service/ConfigurationLoaderService.java` sa sumusunod na format:

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

## Notes

- The `code` tag is used to identify the file path, `content` tag is used to serialize the configuration object.

- The `code` tag is used as a special tag to identify the XML data.

- The `content` tag is used as a special tag to serialize the configuration object.

- The `content` tag is used for the <code>&lt;content&gt;</code> tag, which is a special tag for the configuration object.

- The whole XML file is the XML content of the configuration object, which is used as the XML serialization format.

- The output `<result>` tag is used to identify the XML data.

- The output XML file is generated at the same location of the input XML file.

- The input XML content is parsed as the XML file content.

- When the XML file content is deserialized to an object, the XML file content is used as the configuration object.

- The XML file content is read from the `src/main/java/com/example/config/service/` directory.

- The XML file content is read from the `src/main/resources/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/conf/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/WEB-INF/classes/com/example/config/service/` directory.

- The XML file content is read from the `/