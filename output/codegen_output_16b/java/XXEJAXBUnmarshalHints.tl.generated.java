{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }
}
```


## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/datamodel/service/DataProcessingService.java` sa sumusunod na format:

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

## Sample XML String

```xml
<?xml version="1.0" encoding="UTF-8"?>
<userProfile>
    <name>Sam</name>
    <email>sam@gmail.com</email>
    <userId>1</userId>
</userProfile>
```