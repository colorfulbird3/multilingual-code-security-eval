    </code>
</result>
```



## Usage

```java
import com.example.service.UrlPreviewService;

public class MyApplication extends Application {
  public static void main(String[] args) {
    new UrlPreviewService().getUrlContentPreview("http://example.com");
  }
}
```

## Usage Notes

The `http://` is optional.

## Sample Output

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

[source,xml,lang=fr]
----

<!-- language: xml -->
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
----
