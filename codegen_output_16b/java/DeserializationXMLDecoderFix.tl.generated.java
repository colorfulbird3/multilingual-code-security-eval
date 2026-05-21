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

## References

[Configuration Loading Service](https://developer.android.com/training/articles/basic-configuration-load)
