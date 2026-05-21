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

I-output ang kumpletong code para sa `src/main/java/com/example/config/service/ConfigurationLoaderService.java` sa sumusunod na format:

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

## Examples

- `<code>
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    UserPreferences userPref = (UserPreferences) loader.loadConfiguration("<xml/>");
    System.out.println(userPref.getUsername());
</code>
- `<code>
    FileInputStream input = new FileInputStream("/path/to/file");
    ObjectInputStream reader = new ObjectInputStream(input);
    UserPreferences userPref = (UserPreferences) reader.readObject();
    System.out.println(userPref.getUsername());
</code>
- `<code>
    FileOutputStream output = new FileOutputStream("/path/to/file");
    OutputStreamWriter writer = new OutputStreamWriter(output);
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    loader.saveConfiguration(writer, userPref);
</code>
- `<code>
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("/path/to/file"));
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    loader.saveConfiguration(output, userPref);
</code>
- `<code>
    FileInputStream input = new FileInputStream("/path/to/file");
    ObjectInputStream reader = new ObjectInputStream(input);
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    UserPreferences userPref = (UserPreferences) loader.loadConfiguration(reader);
    System.out.println(userPref.getUsername());
</code>
- `<code>
    FileOutputStream output = new FileOutputStream("/path/to/file");
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    loader.saveConfiguration(output, userPref);
</code>
- `<code>
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("/path/to/file"));
    XMLConfigurationLoader loader = new XMLConfigurationLoader();
    loader.saveConfiguration(output, userPref);
</code>
```

## Known Bugs

- Dapat nagpapahit ang laghit sa kailangan ng `java.beans.XMLDec