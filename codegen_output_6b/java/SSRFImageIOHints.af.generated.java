imageio.ImageIO#read` para basahin at i-parse ang image data mula sa URL.
- Isama ang naaangkop na exception handling
- Ang code ay dapat concise at efficient
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ImageService.java` sa sumusunod na format:

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

**IMPORTANT**:

- `path` ang kumpletong parameter na `ImageService.processImageFromUrl` na mula sekungin sa URL.
- `content` ang kumpletong parameter na `ImageService.processImageFromUrl` na mula sekungin sa string, ng nagpapahintulot na URL na larawan.

## Example Code

```xml
<result>
    <code>
        <path>
            pathName
        </path>
        <content>
            <![CDATA[
            content
        ]]>
        </content>
    </code>
</result>
```

## References

- [How to implement a RESTful API with Java](http://www.javacodegeeks.com/2013/06/how-to-implement-a-restful-api-with-java/)
- [How to implement a RESTful API with Java 8](http://www.javacodegeeks.com/2014/06/how-to-implement-a-restful-api-with-java-8.html)
- [How to implement a RESTful API with Java 8+](http://www.javacodegeeks.com/2014/06/how-to-implement-a-restful-api-with-java-8-plus.html)

## Test Code

Test your code using the following command:

    $ kalibro -junit com.example.service.ImageServiceTest

## Notes

Nangalakalakalo ng isaang nagbukalawangsit umao kayong sa kalibro, kung nagbukalawangsit umao ng pamamit sa kanilang laro

**Ang pagpapatupad ng **`processImageFromUrl`** method na ito ay dapat nanggawin ang nangkapangapaan na ng pagpapatupad ng **`ImageIO#read`**, ng mula sa URL.

**RESTful API**

- Use `kalibro` to test your code.

**Security**

- Do not expose any user