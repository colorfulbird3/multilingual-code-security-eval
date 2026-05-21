

## Example

## Usage

```java
public class OSSService {

    public static void main(String[] args) {
        OSSService ossService = new OSSService();
        System.out.println(ossService.uploadFile("file1.txt", "content1".getBytes()));
    }
}
```

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

"""
